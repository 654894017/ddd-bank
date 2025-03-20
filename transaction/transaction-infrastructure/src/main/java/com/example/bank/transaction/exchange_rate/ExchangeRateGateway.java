package com.example.bank.transaction.exchange_rate;

import com.example.bank.transaction.account.model.ExchangeRate;
import com.example.bank.transaction.gateway.IExchangeRateGateway;
import com.example.bank.transaction.types.Currency;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeRateGateway implements IExchangeRateGateway {
    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
//        if (event_source.equals(target)) {
        return new ExchangeRate(BigDecimal.ONE, source, target);
//        }

    }
}
