package com.example.bank.transaction.repository;

import com.alibaba.cola.dto.PageResponse;
import com.example.bank.transaction.account.model.TransactionId;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.gateway.ITrasactionGateway;
import com.example.bank.transaction.transaction.entity.Transaction;

public class TrasactionGateway implements ITrasactionGateway {
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
