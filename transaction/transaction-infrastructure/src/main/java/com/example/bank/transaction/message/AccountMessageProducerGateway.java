package com.example.bank.transaction.message;

import com.example.bank.transaction.gateway.IAccountMessageProducerGateway;
import ddd.core.Event;
import org.springframework.stereotype.Service;

@Service
public class AccountMessageProducerGateway implements IAccountMessageProducerGateway {
    @Override
    public void send(Event event) {

    }
}
