package com.example.springrandom.messaging;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import static com.example.springrandom.messaging.MessageConstants.SAMPLE_OUTPUT;

@Component
public class MessageSender {

    private final StreamBridge bridge;

    public MessageSender(StreamBridge bridge) {
        this.bridge = bridge;
    }

    public void send(final String text) {
        bridge.send(SAMPLE_OUTPUT, text);
        System.out.println("Sent '" + text + "'");
    }

    public void sendDelay(final String text) {
        bridge.send(MessageConstants.SAMPLE_OUTPUT_DELAY, text);
        System.out.println("Sent '" + text + "'");
    }
}
