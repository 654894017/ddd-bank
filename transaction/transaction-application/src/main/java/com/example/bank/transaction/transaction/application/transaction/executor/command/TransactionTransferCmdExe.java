package com.example.bank.transaction.transaction.application.transaction.executor.command;

import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.account.model.Account;
import com.example.bank.transaction.account.model.AccountNumber;
import com.example.bank.transaction.account.model.ExchangeRate;
import com.example.bank.transaction.account.model.UserId;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.event.TransferTransactionSucceedEvent;
import com.example.bank.transaction.gateway.IAccountGateway;
import com.example.bank.transaction.gateway.IAccountMessageProducerGateway;
import com.example.bank.transaction.gateway.IExchangeRateGateway;
import com.example.bank.transaction.gateway.ITrasactionGateway;
import com.example.bank.transaction.transaction.AccountTransferDomainService;
import com.example.bank.transaction.transaction.model.Transaction;
import com.example.type.Currency;
import com.example.type.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionTransferCmdExe {
    private final IAccountGateway accountRepository;
    private final IAccountMessageProducerGateway transferMessageProducerGateway;
    private final IExchangeRateGateway exchangeRateGateway;
    private final AccountTransferDomainService accountTransferDomainService;
    private final ITrasactionGateway transferTrasactionGateway;

    @Transactional(rollbackFor = Exception.class)
    public SingleResponse<Boolean> transfer(AccountTransferCmd cmd) {
        Money targetMoney = new Money(cmd.getTargetAmount(), new Currency(cmd.getTargetCurrency()));

        Account sourceAccount = accountRepository.find(new UserId(cmd.getSourceUserId()));

        Account targetAccount = accountRepository.find(new AccountNumber(cmd.getTargetAccountNumber()));

        ExchangeRate exchangeRate = exchangeRateGateway.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        Transaction transaction = accountTransferDomainService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 记录交易记录
        Long transferTransactionId = transferTrasactionGateway.save(transaction);
        // 发送消息用于审计日志、短信通知
        TransferTransactionSucceedEvent event = new TransferTransactionSucceedEvent(
                transferTransactionId,
                sourceAccount.getId().getValue(),
                targetAccount.getId().getValue(),
                cmd.getTargetAmount(), cmd.getTargetCurrency()
        );
        transferMessageProducerGateway.send(event);
        return SingleResponse.buildSuccess();
    }
}
