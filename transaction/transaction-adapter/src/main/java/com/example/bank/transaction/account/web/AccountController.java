package com.example.bank.transaction.account.web;

import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.application.facade.account.IAccountApplicationService;
import com.example.bank.transaction.application.facade.account.dto.command.AccountDepositCmd;
import com.example.bank.transaction.application.facade.account.dto.command.AccountWithdrawCmd;
import com.example.bank.transaction.constant.API;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping(API.WEB_API_PATH + "account")
public class AccountController {
    private final IAccountApplicationService accountApplicationService;

    /**
     * 存款
     *
     * @param cmd
     * @param session
     * @return
     */
    @PostMapping("deposit")
    public SingleResponse<Boolean> deposit(@Valid AccountDepositCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        return accountApplicationService.deposit(cmd);
    }

    /**
     * 取款
     *
     * @param cmd
     * @param session
     * @return
     */
    @PostMapping("withdraw")
    public SingleResponse<Boolean> withdraw(@Valid AccountWithdrawCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        return accountApplicationService.withdraw(cmd);
    }

}
