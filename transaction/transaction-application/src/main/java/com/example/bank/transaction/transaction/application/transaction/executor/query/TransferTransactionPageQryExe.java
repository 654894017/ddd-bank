package com.example.bank.transaction.transaction.application.transaction.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.transaction.ITrasactionRepository;
import com.example.bank.transaction.transaction.application.transaction.TransactionAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferTransactionPageQryExe {
    private final ITrasactionRepository transactionRepository;
    private final TransactionAssembler transactionAssembler;

    public PageResponse<TransactionDTO> query(TransferTransactionPageQry qry) {
        return transactionRepository.query(qry);
    }

}
