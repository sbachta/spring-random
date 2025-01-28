package com.example.springrandom.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class Receiver {

    @Bean("test")
    public Consumer<Message<String>> receiveQueue() {
        return message -> {
            System.out.println("Received test <" + message + ">");
        };
    }

    @Bean("memo")
    public Consumer<Message<String>> receive() {
        return message -> {
            System.out.println("Received memo <" + message + ">");
        };
    }

    @Bean("final")
    public Consumer<Message<String>> receiveFinal() {
        return message -> {
            System.out.println("Received final <" + message + ">");
        };
    }

}