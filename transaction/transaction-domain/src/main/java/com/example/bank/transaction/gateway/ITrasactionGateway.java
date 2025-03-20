package com.example.bank.transaction.gateway;

import com.alibaba.cola.dto.PageResponse;
import com.example.bank.transaction.account.model.TransactionId;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.transaction.entity.Transaction;

public interface ITrasactionGateway {
    Transaction find(TransactionId transactionId);

    PageResponse<TransactionDTO> query(TransferTransactionPageQry qry);

    Long save(Transaction transaction);
}
