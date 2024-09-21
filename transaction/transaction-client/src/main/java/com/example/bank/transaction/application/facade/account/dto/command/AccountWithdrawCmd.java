package com.example.bank.transaction.application.facade.account.dto.command;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class AccountWithdrawCmd extends Command {

    private Long sourceUserId;
    @NotEmpty(message = "账户货币类型不允许为空")
    private String currency;
    @DecimalMin(value = "0.01", message = "金额必须大于或等于0.01")
    private BigDecimal money;

}
