package com.example.bank.transaction.transaction;

import com.example.bank.transaction.account.entity.Account;
import com.example.bank.transaction.transaction.entity.Transaction;
import com.example.bank.transaction.types.ExchangeRate;
import com.example.bank.transaction.types.Money;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferDomainService {

    public Transaction transfer(Account sourceAccount, Account targetAccount,
                                Money targetMoney, ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchageTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
        return new Transaction().toTransferTransaction(sourceAccount.getId(), targetAccount.getId(), sourceMoney);
    }
}
