package com.example.bank.transaction.application.facade.account.dto.event;


import com.alibaba.cola.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDepositSucceedEvent extends DTO {
    private Long transactionId;
    private Long sourceAccountId;
    private BigDecimal amout;
    private String currency;
//
//    @Override
//    public String eventId() {
//        return transactionId + "";
//    }
}
