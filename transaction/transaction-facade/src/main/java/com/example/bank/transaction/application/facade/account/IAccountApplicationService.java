package com.example.bank.transaction.application.facade.account;


import com.example.bank.transaction.application.facade.account.dto.AccountDTO;
import com.example.bank.transaction.application.facade.account.dto.command.AccountDepositCmd;
import com.example.bank.transaction.application.facade.account.dto.command.AccountWithdrawCmd;
import com.example.bank.transaction.application.facade.account.dto.query.AccountByAccountIdQry;
import ddd.core.SingleResponse;

public interface IAccountApplicationService {
    SingleResponse<Boolean> deposit(AccountDepositCmd cmd);

    SingleResponse<Boolean> withdraw(AccountWithdrawCmd cmd);

    SingleResponse<AccountDTO> get(AccountByAccountIdQry qry);
}