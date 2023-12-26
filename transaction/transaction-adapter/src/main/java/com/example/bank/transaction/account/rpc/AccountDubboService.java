package com.example.bank.transaction.account.rpc;

import com.example.bank.transaction.application.facade.account.IAccountApplicationService;
import com.example.bank.transaction.constant.RPC;
import com.example.bank.transaction.transaction.application.account.AccountApplicationService;
import com.example.bank.transaction.transaction.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.transaction.transaction.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.transaction.transaction.application.account.executor.query.AccountByAccountIdQryExe;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(timeout = RPC.DEFAULT_TIMEOUT)
public class AccountDubboService extends AccountApplicationService implements IAccountApplicationService {
    public AccountDubboService(AccountByAccountIdQryExe accountByAccountIdQryExe, AccountDepositCmdExe accountDepositCmdExe, AccountWithdrawCmdExe accountWithdrawCmdExe) {
        super(accountByAccountIdQryExe, accountDepositCmdExe, accountWithdrawCmdExe);
    }
}
