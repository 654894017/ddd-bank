package com.example.bank.transaction.transaction.application.account.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.account.model.Account;
import com.example.bank.transaction.account.model.AccountId;
import com.example.bank.transaction.application.facade.account.dto.AccountDTO;
import com.example.bank.transaction.application.facade.account.dto.query.AccountByAccountIdQry;
import com.example.bank.transaction.gateway.IAccountGateway;
import com.example.bank.transaction.transaction.application.account.AccountAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountByAccountIdQryExe {
    private final IAccountGateway accountGateway;
    private final AccountAssembler accountAssembler;

    public SingleResponse<AccountDTO> execute(AccountByAccountIdQry qry) {
        Account account = accountGateway.find(new AccountId(qry.getAccountId()));
        return SingleResponse.of(accountAssembler.to(account));
    }
}
