package com.example.bank.transaction.account.model;

import com.example.bank.transaction.account.exception.DailyLimitExceededException;
import com.example.bank.transaction.account.exception.InsufficientFundsException;
import com.example.bank.transaction.account.exception.InvalidCurrencyException;
import com.example.bank.transaction.types.Currency;
import com.example.bank.transaction.types.Money;
import lombok.Data;

@Data
public class Account {
    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;
    private Currency currency;

    // 转出
    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException("账户资金不足");
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException("超出日转账限额");
        }
        this.available = this.available.subtract(money);
    }

    // 转入
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException("不支持的货币");
        }
        this.available = this.available.add(money);

    }
}
