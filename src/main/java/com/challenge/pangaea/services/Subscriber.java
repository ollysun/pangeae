package com.challenge.pangaea.services;

import com.challenge.pangaea.config.RabbitMqConfiguration;
import com.challenge.pangaea.model.PublishMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Subscriber {

    // listener for Queue1
    @RabbitListener(queues = RabbitMqConfiguration.QUEUE1)
    public void subscribeQueue1Message(final PublishMessage message) {
        log.info("Received queue1 message is: {}", message);
    }

    // listener for Queue2
    @RabbitListener(queues = RabbitMqConfiguration.QUEUE2)
    public void subscribeQueue2Message(final PublishMessage message) {
        log.info("Received queue2 message is: {}", message);
    }

}
