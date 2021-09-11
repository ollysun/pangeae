package com.challenge.pangaea.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.challenge.pangaea.model.PublishMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Subscriber.class})
@ExtendWith(SpringExtension.class)
public class SubscriberTest {
    @Autowired
    private Subscriber subscriber;

    @Test
    public void testSubscribeQueue1Message() {
        PublishMessage publishMessage = new PublishMessage("Not all who wander are lost");
        this.subscriber.subscribeQueue1Message(publishMessage);
        assertEquals("Not all who wander are lost", publishMessage.getMessage());
    }

    @Test
    public void testSubscribeQueue2Message() {
        PublishMessage publishMessage = new PublishMessage("Not all who wander are lost");
        this.subscriber.subscribeQueue2Message(publishMessage);
        assertEquals("Not all who wander are lost", publishMessage.getMessage());
    }
}

