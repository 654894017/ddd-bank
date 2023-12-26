package com.example.bank.transaction.transaction.application.transaction;

import com.example.bank.transaction.application.facade.transfer_transaction.ITransactionApplicationService;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.TransactionDTO;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.transaction.application.facade.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.transaction.application.transaction.executor.command.TransactionTransferCmdExe;
import com.example.bank.transaction.transaction.application.transaction.executor.query.TransferTransactionPageQryExe;
import ddd.core.PageResponse;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionApplicationService implements ITransactionApplicationService {
    private final TransactionTransferCmdExe transactionTransferCmdExe;
    private final TransferTransactionPageQryExe transferTransactionPageQryExe;

    @Override
    public SingleResponse<Boolean> transfer(AccountTransferCmd cmd) {
        return transactionTransferCmdExe.transfer(cmd.getSourceUserId(),
                cmd.getTargetAccountNumber(), cmd.getTargetAmount(), cmd.getTargetCurrency());
    }

    @Override
    public PageResponse<TransactionDTO> query(TransferTransactionPageQry qry) {
        return transferTransactionPageQryExe.query(qry);
    }

}
