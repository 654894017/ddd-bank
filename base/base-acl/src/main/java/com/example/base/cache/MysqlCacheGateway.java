package com.example.base.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MysqlCacheGateway implements ICacheGateway {

    @Override
    public boolean delete(String key) {
        return false;
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return null;
    }

    @Override
    public boolean put(String key, Object value) {
        return false;
    }
}
