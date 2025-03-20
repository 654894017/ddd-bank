package com.example.bank.transaction.transaction.application.account;

import com.example.bank.transaction.account.model.Account;
import com.example.bank.transaction.application.facade.account.dto.AccountDTO;
import com.example.bank.transaction.application.facade.account.dto.command.AccountCreateCmd;
import org.springframework.stereotype.Component;

@Component
public class AccountAssembler {

    // 这边可以调用基础设施接口，因为有些属性需要调用服务获取

    public AccountDTO to(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setCurrency(account.getCurrency().getValue());
        //.......
        return accountDTO;
    }

    public Account to(AccountCreateCmd cmd) {
        return null;
    }

}
