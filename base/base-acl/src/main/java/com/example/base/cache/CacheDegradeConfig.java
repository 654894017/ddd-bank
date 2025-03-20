package com.example.base.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class CacheDegradeConfig {

    @Bean
    public CacheGatewayProxyHandler cacheGatewayProxyHandler(
            ICacheGateway redisCacheGateway,
            ICacheGateway mysqlCacheGateway
    ) {
        return new CacheGatewayProxyHandler(
                redisCacheGateway,
                mysqlCacheGateway
        );
    }

    @Bean
    public ICacheGateway cacheGateway(CacheGatewayProxyHandler handler) {
        Object proxyObj = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{ICacheGateway.class},
                handler
        );
        return (ICacheGateway) proxyObj;
    }
}
