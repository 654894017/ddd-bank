package com.example.bank.transaction.account.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class AccountConsumer {
    /**
     * 下发短信
     *
     * @param data
     * @param ack
     */
    @KafkaListener(groupId = "account_transfer_transaction_message",
            topics = {"account_transfer_transaction_topic"},
            containerFactory = "account_transfer_transaction_kafka_factory")
    public void listenerAccountTransferTransactionMessage(ConsumerRecord<String, String> data, Acknowledgment ack) {


    }

    /**
     * 审计日志
     *
     * @param data
     * @param ack
     */
    @KafkaListener(groupId = "account_transfer_transaction_audit",
            topics = {"account_transfer_transaction_topic"},
            containerFactory = "account_transfer_transaction_kafka_factory")
    public void listenerAccountTransferTransactionAudit(ConsumerRecord<String, String> data, Acknowledgment ack) {


    }
}
