package com.example.base.dict;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DictGateway implements IDictGateway {
    @Override
    public Map<String, Dict> get(String category) {
        return null;
    }

}
