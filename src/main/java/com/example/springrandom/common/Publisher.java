package com.example.springrandom.common;

import org.springframework.messaging.Message;

@FunctionalInterface
public interface Publisher<MESSAGE> {

    void publish(String exchange, Message<MESSAGE> message);
}
