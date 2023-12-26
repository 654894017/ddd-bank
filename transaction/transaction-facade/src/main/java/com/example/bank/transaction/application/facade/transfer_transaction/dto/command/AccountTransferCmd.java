package com.example.bank.transaction.application.facade.transfer_transaction.dto.command;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class AccountTransferCmd {

    private Long sourceUserId;
    @NotEmpty(message = "收款账户不允许为空")
    private String targetAccountNumber;
    @DecimalMin(value = "0.01", message = "金额必须大于或等于0.01")
    private BigDecimal targetAmount;
    @NotEmpty(message = "收款账户货币类型允许为空")
    private String targetCurrency;

}
