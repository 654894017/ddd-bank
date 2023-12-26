package com.example.bank.transaction.transaction.application.account.executor.command;

import com.example.bank.transaction.account.IAccountRepository;
import com.example.bank.transaction.account.entity.Account;
import com.example.bank.transaction.application.facade.account.dto.command.AccountDepositCmd;
import com.example.bank.transaction.application.facade.account.dto.event.AccountDepositSucceedEvent;
import com.example.bank.transaction.gateway.IAccountMessageProducerGateway;
import com.example.bank.transaction.transaction.ITrasactionRepository;
import com.example.bank.transaction.transaction.entity.Transaction;
import com.example.bank.transaction.types.AccountId;
import com.example.bank.transaction.types.Currency;
import com.example.bank.transaction.types.Money;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountDepositCmdExe {
    private final IAccountRepository accountRepository;
    private final IAccountMessageProducerGateway accountMessageProducerGateway;
    private final ITrasactionRepository transferTrasactionRepository;

    @Transactional(rollbackFor = Exception.class)
    public SingleResponse<Boolean> deposit(AccountDepositCmd cmd) {
        Account account = accountRepository.find(new AccountId(cmd.getSourceUserId()));
        account.deposit(new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        Transaction transaction = new Transaction().toDepositTransaction(account.getId(), new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        accountRepository.save(account);
        // 记录交易记录
        Long transferTransactionId = transferTrasactionRepository.save(transaction);
        // 发送消息用于审计日志、短信通知
        AccountDepositSucceedEvent event = new AccountDepositSucceedEvent(
                transferTransactionId, account.getId().getValue(),
                cmd.getMoney(), cmd.getCurrency()
        );
        accountMessageProducerGateway.send(event);
        return SingleResponse.buildSuccess();
    }
}
