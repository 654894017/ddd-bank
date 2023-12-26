package com.example.bank.transaction.repository;

import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.transaction.ITrasactionRepository;
import com.example.bank.transaction.transaction.entity.Transaction;
import com.example.bank.transaction.types.TransactionId;
import ddd.core.PageResponse;

public class TrasactionRepository implements ITrasactionRepository {
    @Override
    public Transaction find(TransactionId transactionId) {
        return null;
    }

    @Override
    public PageResponse<TransactionDTO> query(TransferTransactionPageQry qry) {
        return null;
    }

    @Override
    public Long save(Transaction transaction) {
        return null;
    }
}
