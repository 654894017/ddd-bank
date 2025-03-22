package com.example.bank.transaction.gateway.exchangerate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.bank.transaction.account.model.ExchangeRate;
import com.example.bank.transaction.gateway.IExchangeRateGateway;
import com.example.type.Currency;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeRateGateway implements IExchangeRateGateway {
    private final RedissonClient redissonClient;

    @Override
    @SentinelResource(value = "exchange_rate_resource", fallback = "exchangeRateFallback")
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        ExchangeRate exchangeRate = (ExchangeRate) redissonClient.getBucket(getCacheKey(source, target)).get();
        if (exchangeRate == null) {
            //调用外部服务获取汇率
            exchangeRate = getExchangeRate();
            redissonClient.getBucket(getCacheKey(source, target)).set(exchangeRate);
        }
        return exchangeRate;
    }
    private ExchangeRate getExchangeRate(){
        //调用外部服务获取汇率
        return null;
    }

    private String getCacheKey(Currency source, Currency target) {
        return String.format("exchange_rate_%s_%s", source.getValue(), target.getValue());
    }

    /**
     * @param source
     * @param target
     * @return
     */
    public ExchangeRate exchangeRateFallback(Currency source, Currency target) {
        //读取数据库默认缓存下来的
        return new ExchangeRate(BigDecimal.ONE, source, target);
    }

}
