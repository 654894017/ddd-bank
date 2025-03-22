package com.example.bank.transaction.gateway;

import com.example.bank.transaction.account.model.ExchangeRate;
import com.example.type.Currency;

public interface IExchangeRateGateway {
    ExchangeRate getExchangeRate(Currency source, Currency target);

}

