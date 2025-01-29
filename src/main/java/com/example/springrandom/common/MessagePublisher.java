package com.example.springrandom.common;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher<MESSAGE> implements Publisher<MESSAGE> {

    private final StreamBridge streamBridge;

    public MessagePublisher(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void publish(String exchange, MESSAGE message) {
        streamBridge.send(exchange, message);
    }
}
