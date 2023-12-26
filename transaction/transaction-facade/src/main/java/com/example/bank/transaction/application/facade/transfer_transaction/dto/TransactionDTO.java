package com.example.bank.transaction.application.facade.transfer_transaction.dto;

import ddd.core.DTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDTO extends DTO {
    private Long id;
    private String accountNumber;
    private Long userId;
    private BigDecimal availableAmout;
    private BigDecimal dailyLimitAmout;
    private String currency;
}
