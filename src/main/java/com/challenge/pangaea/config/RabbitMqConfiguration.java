package com.challenge.pangaea.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    public static final String QUEUE1 = "topic1";
    public static final String QUEUE2 = "topic2";
    public static final String EXCHANGE = "directExchange";
    public static final String ROUTING_KEY = "test1";
    public static final String ROUTING_KEY2 = "test2";


    @Bean
    public Queue firstQueue(){
        return new Queue(QUEUE1);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue(QUEUE2);
    }

    @Bean
    public DirectExchange directTopicExchange(){
        return new DirectExchange(EXCHANGE,false, true);
    }

    @Bean
    public Binding firstQueueBinding() {
        return BindingBuilder.bind(firstQueue()).to(directTopicExchange()).with(ROUTING_KEY);
    }

    @Bean
    public Binding secondQueueBinding(){
        return BindingBuilder.bind(secondQueue()).to(directTopicExchange()).with(ROUTING_KEY2);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
