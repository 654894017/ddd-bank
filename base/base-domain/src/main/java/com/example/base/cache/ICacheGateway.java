package com.example.base.cache;

public interface ICacheGateway {

    <T> T get(String key, Class<T> clazz);

    boolean put(String key, Object value);

    boolean delete(String key);

}
