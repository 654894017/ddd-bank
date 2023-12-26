package com.example.bank.transaction.account.rpc;

import com.example.bank.transaction.application.facade.transfer_transaction.ITransactionApplicationService;
import com.example.bank.transaction.constant.RPC;
import com.example.bank.transaction.transaction.application.transaction.TransactionApplicationService;
import com.example.bank.transaction.transaction.application.transaction.executor.command.TransactionTransferCmdExe;
import com.example.bank.transaction.transaction.application.transaction.executor.query.TransferTransactionPageQryExe;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(timeout = RPC.DEFAULT_TIMEOUT)
public class TransactionDubboService extends TransactionApplicationService implements ITransactionApplicationService {
    public TransactionDubboService(TransactionTransferCmdExe transactionTransferCmdExe, TransferTransactionPageQryExe transferTransactionPageQryExe) {
        super(transactionTransferCmdExe, transferTransactionPageQryExe);
    }
}
