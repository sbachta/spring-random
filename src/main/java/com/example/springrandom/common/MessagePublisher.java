package com.example.springrandom.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.function.StreamBridge;

import static java.util.Collections.singletonMap;

@Slf4j
public abstract class MessagePublisher<MESSAGE> { //implements Publisher<MESSAGE> {

//    @Autowired
//    protected StreamBridge streamBridge;
//    @Getter
//    protected final String queueName;

//    public MessagePublisher(String queueName) {
//        this.queueName = queueName;
//    }

//    public Result<Boolean, Problem> publish(final MESSAGE message, final String eventType) {
//        return rabbitTrap(() -> {
//            log.info("Publishing '{}'", message);
//
//            return streamBridge.send(queueName, createMessage(message, new MessageHeaders(singletonMap("eventType", eventType))));
//        });
//    }
}
