package com.example.bank.transaction.gateway;


import com.alibaba.cola.dto.DTO;

public interface IAccountMessageProducerGateway {
    void send(DTO event);
}
