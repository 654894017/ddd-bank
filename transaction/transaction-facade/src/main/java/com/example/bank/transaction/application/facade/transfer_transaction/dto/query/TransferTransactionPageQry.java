package com.example.bank.transaction.application.facade.transfer_transaction.dto.query;

import ddd.core.PageQuery;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferTransactionPageQry extends PageQuery {

    private Long accountId;


}
