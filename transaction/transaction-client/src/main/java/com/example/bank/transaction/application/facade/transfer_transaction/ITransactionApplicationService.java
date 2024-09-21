package com.example.bank.transaction.application.facade.transfer_transaction;


import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;

public interface ITransactionApplicationService {
    SingleResponse<Boolean> transfer(AccountTransferCmd command);

    PageResponse<TransactionDTO> query(TransferTransactionPageQry qry);
}