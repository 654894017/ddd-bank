package com.example.bank.transaction.transaction.application.transaction.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.gateway.ITrasactionGateway;
import com.example.bank.transaction.transaction.application.transaction.TransactionAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferTransactionPageQryExe {
    private final ITrasactionGateway transactionRepository;
    private final TransactionAssembler transactionAssembler;

    public PageResponse<TransactionDTO> execute(TransferTransactionPageQry qry) {
        return transactionRepository.query(qry);
    }

}
