package com.example.bank.transaction.application.facade.account.dto.event;


import ddd.core.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDepositSucceedEvent extends Event {
    private Long transactionId;
    private Long sourceAccountId;
    private BigDecimal amout;
    private String currency;

    @Override
    public String eventId() {
        return transactionId + "";
    }
}
