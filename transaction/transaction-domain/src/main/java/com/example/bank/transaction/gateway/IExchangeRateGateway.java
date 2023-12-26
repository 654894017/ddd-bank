package com.example.bank.transaction.gateway;

import com.example.bank.transaction.types.Currency;
import com.example.bank.transaction.types.ExchangeRate;

public interface IExchangeRateGateway {
    ExchangeRate getExchangeRate(Currency source, Currency target);

}

