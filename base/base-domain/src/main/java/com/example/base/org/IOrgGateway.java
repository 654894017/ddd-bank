package com.example.base.org;

public interface IOrgGateway {

    Org get(Long id);

    String getOrgCode(Long id);

    String getOrgName(Long id);

}
