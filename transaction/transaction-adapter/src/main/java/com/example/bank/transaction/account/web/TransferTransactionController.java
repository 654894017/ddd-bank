package com.example.bank.transaction.account.web;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.application.facade.transfer_transaction.ITransactionApplicationService;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.constant.API;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(API.WEB_API_PATH + "local_transaction")
public class TransferTransactionController {
    private final ITransactionApplicationService transferApplicationService;

    /**
     * 转账
     *
     * @param cmd
     * @param session
     * @return
     */
    @PostMapping("transfer")
    public SingleResponse<Boolean> transfer(@Valid AccountTransferCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        return transferApplicationService.transfer(cmd);
    }

    /**
     * 查询账户交易明细
     *
     * @param qry
     * @param session
     * @return
     */
    @GetMapping("")
    public PageResponse<TransactionDTO> query(@Valid TransferTransactionPageQry qry, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        qry.setAccountId(sourceUserId);
        return transferApplicationService.query(qry);
    }
}
