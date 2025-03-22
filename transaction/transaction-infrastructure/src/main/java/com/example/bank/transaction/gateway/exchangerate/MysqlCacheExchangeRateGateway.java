package com.example.bank.transaction.gateway.exchangerate;

import com.example.bank.transaction.account.model.ExchangeRate;
import com.example.bank.transaction.gateway.IExchangeRateGateway;
import com.example.type.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MysqlCacheExchangeRateGateway implements IExchangeRateGateway {

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        ExchangeRate exchangeRate = new ExchangeRate(BigDecimal.ONE, source, target);
        return exchangeRate;
    }


}
