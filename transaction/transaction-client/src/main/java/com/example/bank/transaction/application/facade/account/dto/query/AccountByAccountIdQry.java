package com.example.bank.transaction.application.facade.account.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountByAccountIdQry extends Query {

    private Long accountId;

}
