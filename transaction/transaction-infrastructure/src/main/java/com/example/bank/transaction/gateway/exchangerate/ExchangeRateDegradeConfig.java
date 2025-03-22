package com.example.bank.transaction.gateway.exchangerate;

import com.example.bank.transaction.gateway.IExchangeRateGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class ExchangeRateDegradeConfig {

    @Bean
    public ExchangeRateGatewayProxyHandler cacheGatewayProxyHandler(
            IExchangeRateGateway exchangeRateGateway,
            IExchangeRateGateway mysqlExchangeRateGateway
    ) {
        return new ExchangeRateGatewayProxyHandler(
                mysqlExchangeRateGateway,
                mysqlExchangeRateGateway
        );
    }

    @Bean
    public IExchangeRateGateway cacheGateway(ExchangeRateGatewayProxyHandler handler) {
        Object proxyObj = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{IExchangeRateGateway.class},
                handler
        );
        return (IExchangeRateGateway) proxyObj;
    }
}
