package com.example.bank.transaction.gateway.exchangerate;


import com.example.bank.transaction.gateway.IExchangeRateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class ExchangeRateGatewayProxyHandler implements InvocationHandler {
    private final IExchangeRateGateway exchangeRateGateway;
    private final IExchangeRateGateway mysqlExchangeRateGateway;
    @Value("${exchangerate.channel.degraded}")
    private Boolean isExchangeRateChannelDegraded;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if (isExchangeRateChannelDegraded) {
            result = method.invoke(mysqlExchangeRateGateway, args);
        } else {
            result = method.invoke(exchangeRateGateway, args);
        }
        return result;
    }
}
