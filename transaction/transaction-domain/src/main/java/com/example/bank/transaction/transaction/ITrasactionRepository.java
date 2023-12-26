package com.example.bank.transaction.transaction;

import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.transaction.entity.Transaction;
import com.example.bank.transaction.types.TransactionId;
import ddd.core.PageResponse;

public interface ITrasactionRepository {
    Transaction find(TransactionId transactionId);

    PageResponse<TransactionDTO> query(TransferTransactionPageQry qry);

    Long save(Transaction transaction);
}
