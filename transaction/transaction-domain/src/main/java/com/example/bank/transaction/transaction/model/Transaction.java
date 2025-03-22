package com.example.bank.transaction.transaction.model;

import com.example.bank.transaction.account.model.AccountId;
import com.example.type.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @SuppressWarnings("unused")
    private long id;
    private Long createTime;
    private AccountId fromAccountId;
    private AccountId toAccountId;
    private Money money;
    private TransactionType transactionType;

    public Transaction toTransferTransaction(AccountId fromAccountId, AccountId toAccountId, Money money) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.money = money;
        this.createTime = System.currentTimeMillis();
        this.transactionType = TransactionType.TRANSFER;
        return this;
    }

    public Transaction toDepositTransaction(AccountId fromAccountId, Money money) {
        this.fromAccountId = fromAccountId;
        this.money = money;
        this.createTime = System.currentTimeMillis();
        this.transactionType = TransactionType.DEPOSIT;
        return this;
    }

    public Transaction toWithdramTransaction(AccountId fromAccountId, Money money) {
        this.fromAccountId = fromAccountId;
        this.money = money;
        this.createTime = System.currentTimeMillis();
        this.transactionType = TransactionType.WITHDRAW;
        return this;
    }

}