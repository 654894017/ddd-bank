package com.example.bank.transaction.gateway.message;

import com.alibaba.cola.dto.DTO;
import com.example.bank.transaction.gateway.IAccountMessageProducerGateway;
import org.springframework.stereotype.Service;

@Service
public class AccountMessageProducerGateway implements IAccountMessageProducerGateway {
    @Override
    public void send(DTO event) {

    }
}
