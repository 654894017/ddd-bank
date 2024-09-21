package com.example.bank.transaction.application.facade.transfer_transaction.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferTransactionPageQry extends PageQuery {

    private Long accountId;


}
