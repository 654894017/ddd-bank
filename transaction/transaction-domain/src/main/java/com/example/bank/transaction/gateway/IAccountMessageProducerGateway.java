package com.example.bank.transaction.gateway;


import ddd.core.Event;

public interface IAccountMessageProducerGateway {
    void send(Event event);
}
