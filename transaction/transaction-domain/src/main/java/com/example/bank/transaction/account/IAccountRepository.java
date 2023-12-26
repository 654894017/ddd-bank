package com.example.bank.transaction.account;

import com.example.bank.transaction.account.entity.Account;
import com.example.bank.transaction.types.AccountId;
import com.example.bank.transaction.types.AccountNumber;
import com.example.bank.transaction.types.UserId;

public interface IAccountRepository {
    Account find(AccountId id);

    Account find(AccountNumber accountNumber);

    Account find(UserId userId);

    Account save(Account account);
}
