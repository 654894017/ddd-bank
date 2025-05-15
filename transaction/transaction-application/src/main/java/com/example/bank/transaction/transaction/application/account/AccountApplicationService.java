package com.example.bank.transaction.transaction.application.account;

import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.application.facade.account.IAccountApplicationService;
import com.example.bank.transaction.application.facade.account.dto.AccountDTO;
import com.example.bank.transaction.application.facade.account.dto.command.AccountDepositCmd;
import com.example.bank.transaction.application.facade.account.dto.command.AccountWithdrawCmd;
import com.example.bank.transaction.application.facade.account.dto.query.AccountByAccountIdQry;
import com.example.bank.transaction.transaction.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.transaction.transaction.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.transaction.transaction.application.account.executor.query.AccountByAccountIdQryExe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountApplicationService implements IAccountApplicationService {
    private final AccountByAccountIdQryExe accountByAccountIdQryExe;
    private final AccountDepositCmdExe accountDepositCmdExe;
    private final AccountWithdrawCmdExe accountWithdrawCmdExe;

    @Override
    public SingleResponse<Boolean> deposit(AccountDepositCmd cmd) {
        return accountDepositCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<Boolean> withdraw(AccountWithdrawCmd cmd) {
        return accountWithdrawCmdExe.withdraw(cmd);
    }

    @Override
    public SingleResponse<AccountDTO> get(AccountByAccountIdQry qry) {
        return accountByAccountIdQryExe.get(qry);
    }
}
