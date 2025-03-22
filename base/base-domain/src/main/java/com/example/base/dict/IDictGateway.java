package com.example.base.dict;

import java.util.Map;

public interface IDictGateway {
    Map<String, Dict> get(String category);
}
