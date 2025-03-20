package com.example.base.org;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Component;

@Component
public class OrgGateway implements IOrgGateway {
    @Override
    @SentinelResource(value = "org_resource", fallback = "orgFallback")
    public Org get(Long id) {
        return null;
    }

    /**
     * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
     *
     * @param id
     * @return
     */
    public Org orgFallback(Long id) {
        return new Org();
    }

    @Override
    public String getOrgCode(Long id) {
        return "";
    }

    @Override
    public String getOrgName(Long id) {
        return "";
    }
}
