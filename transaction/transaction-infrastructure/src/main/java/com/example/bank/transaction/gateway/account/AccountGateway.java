package com.example.bank.transaction.gateway.account;

import com.example.bank.transaction.account.exception.AccountNotFoundException;
import com.example.bank.transaction.account.model.Account;
import com.example.bank.transaction.account.model.AccountId;
import com.example.bank.transaction.account.model.AccountNumber;
import com.example.bank.transaction.account.model.UserId;
import com.example.bank.transaction.gateway.IAccountGateway;
import com.example.bank.transaction.persistence.account.AccountDO;
import com.example.bank.transaction.persistence.account.AccountFactory;
import com.example.bank.transaction.persistence.account.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountGateway implements IAccountGateway {
    private final AccountMapper accountDAO;

    @Override
    public Account find(AccountId id) {
        AccountDO accountDO = accountDAO.selectById(id.getValue());
        return AccountFactory.toAccount(accountDO);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDO accountDO = accountDAO.selectByAccountNumber(accountNumber.getValue());
        if (accountDO == null) {
            throw new AccountNotFoundException(String.format("账户[%s]不存在", accountNumber.getValue()));
        }
        return AccountFactory.toAccount(accountDO);
    }

    @Override
    public Account find(UserId userId) {
        AccountDO accountDO = accountDAO.selectByUserId(userId.getId());
        if (accountDO == null) {
            throw new AccountNotFoundException("账户不存在");
        }
        return AccountFactory.toAccount(accountDO);
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDO = AccountFactory.fromAccount(account);
        if (accountDO.getId() == null) {
            accountDAO.insert(accountDO);
        } else {
            accountDAO.update(accountDO);
        }
        return AccountFactory.toAccount(accountDO);
    }

}
