package com.example.bank.transaction.transaction.application.account.executor.command;

import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.account.model.Account;
import com.example.bank.transaction.account.model.AccountId;
import com.example.bank.transaction.application.facade.account.dto.command.AccountWithdrawCmd;
import com.example.bank.transaction.application.facade.account.dto.event.AccountWithdrawSucceedEvent;
import com.example.bank.transaction.gateway.IAccountGateway;
import com.example.bank.transaction.gateway.IAccountMessageProducerGateway;
import com.example.bank.transaction.gateway.ITrasactionGateway;
import com.example.bank.transaction.transaction.model.Transaction;

import com.example.type.Currency;
import com.example.type.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountWithdrawCmdExe {
    private final IAccountGateway accountRepository;
    private final IAccountMessageProducerGateway accountMessageProducerGateway;
    private final ITrasactionGateway transferTrasactionRepository;

    @Transactional(rollbackFor = Exception.class)
    public SingleResponse<Boolean> withdraw(AccountWithdrawCmd cmd) {
        Account account = accountRepository.find(new AccountId(cmd.getSourceUserId()));
        account.withdraw(new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        Transaction transaction = new Transaction()
                .toWithdramTransaction(
                        account.getId(),
                        new Money(cmd.getMoney(), new Currency(cmd.getCurrency()))
                );
        accountRepository.save(account);
        // 记录交易记录
        Long transferTransactionId = transferTrasactionRepository.save(transaction);
        // 发送消息用于审计日志、短信通知
        AccountWithdrawSucceedEvent event = new AccountWithdrawSucceedEvent(
                transferTransactionId, account.getId().getValue(),
                cmd.getMoney(), cmd.getCurrency()
        );
        accountMessageProducerGateway.send(event);
        return SingleResponse.buildSuccess();
    }

}
