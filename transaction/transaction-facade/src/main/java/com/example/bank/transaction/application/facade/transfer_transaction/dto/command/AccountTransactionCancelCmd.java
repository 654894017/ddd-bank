package com.example.bank.transaction.application.facade.transfer_transaction.dto.command;

import lombok.Data;

@Data
public class AccountTransactionCancelCmd {

    private Long transactionId;

}
