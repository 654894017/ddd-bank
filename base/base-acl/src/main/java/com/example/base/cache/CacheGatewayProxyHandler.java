package com.example.base.cache;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class CacheGatewayProxyHandler implements InvocationHandler {
    private final ICacheGateway redisCacheGateway;
    private final ICacheGateway mysqlCacheGateway;
    @Value("${cache.degraded}")
    private boolean isDegraded;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if (isDegraded) {
            result = method.invoke(mysqlCacheGateway, args);
        } else {
            result = method.invoke(redisCacheGateway, args);
        }
        return result;
    }
}
