package com.challenge.pangaea.services;

import com.challenge.pangaea.config.RabbitMqConfiguration;
import com.challenge.pangaea.model.PublishMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class Publisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(PublishMessage publishMessage, String routingKey){
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.EXCHANGE, routingKey, publishMessage);
    }

}
