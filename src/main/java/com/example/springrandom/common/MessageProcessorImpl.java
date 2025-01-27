package com.example.springrandom.common;

import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MessageProcessorImpl {//implements MessageProcessor<TestMessage> {

//    @Override
//    @Bean("yml-name")
//    public Consumer<Message<TestMessage>> read() {
//        return message -> {
//            final var eventType = message.getHeaders().get("eventType");
//
//            if ("appTest".equals(eventType)) {
//                service code here
//            }
//        };
//    }
}
