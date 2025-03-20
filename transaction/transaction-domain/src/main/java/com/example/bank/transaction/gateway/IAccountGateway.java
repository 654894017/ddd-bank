package com.example.bank.transaction.gateway;

import com.example.bank.transaction.account.model.Account;
import com.example.bank.transaction.account.model.AccountId;
import com.example.bank.transaction.account.model.AccountNumber;
import com.example.bank.transaction.account.model.UserId;

public interface IAccountGateway {
    Account find(AccountId id);

    Account find(AccountNumber accountNumber);

    Account find(UserId userId);

    Account save(Account account);
}
