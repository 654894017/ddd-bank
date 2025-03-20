package com.example.base.cache;

import com.alibaba.fastjson2.JSONObject;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisCacheGateway implements ICacheGateway {

    private final RedissonClient redissonClient;

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String result = (String) redissonClient.getBucket(key).get();
        return JSONObject.parseObject(result, clazz);
    }

    @Override
    public boolean put(String key, Object value) {
        redissonClient.getBucket(key).set(JSONObject.toJSONString(value));
        return true;
    }

    @Override
    public boolean delete(String key) {
        return redissonClient.getBucket(key).delete();
    }


}
