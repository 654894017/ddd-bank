package com.example.bank.transaction.transaction.application.transaction.executor.command;

import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.account.IAccountRepository;
import com.example.bank.transaction.account.entity.Account;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.event.TransferTransactionSucceedEvent;
import com.example.bank.transaction.gateway.IAccountMessageProducerGateway;
import com.example.bank.transaction.gateway.IExchangeRateGateway;
import com.example.bank.transaction.transaction.AccountTransferDomainService;
import com.example.bank.transaction.transaction.ITrasactionRepository;
import com.example.bank.transaction.transaction.entity.Transaction;
import com.example.bank.transaction.types.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionTransferCmdExe {
    private final IAccountRepository accountRepository;
    private final IAccountMessageProducerGateway transferMessageProducerGateway;
    private final IExchangeRateGateway exchangeRateGateway;
    private final AccountTransferDomainService accountTransferDomainService;
    private final ITrasactionRepository transferTrasactionRepository;

    @Transactional(rollbackFor = Exception.class)
    public SingleResponse<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));

        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));

        ExchangeRate exchangeRate = exchangeRateGateway.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        Transaction transaction = accountTransferDomainService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 记录交易记录
        Long transferTransactionId = transferTrasactionRepository.save(transaction);
        // 发送消息用于审计日志、短信通知
        TransferTransactionSucceedEvent event = new TransferTransactionSucceedEvent(
                transferTransactionId,
                sourceAccount.getId().getValue(),
                targetAccount.getId().getValue(),
                targetAmount, targetCurrency
        );
        transferMessageProducerGateway.send(event);
        return SingleResponse.buildSuccess();
    }
}
