package com.example.springrandom.web;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.messaging.TestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.springrandom.common.MessageConstants.SAMPLE_OUTPUT;

@RestController
public class RandomController {

    private final MessagePublisher<TestMessage> sender;

    public RandomController(
            final MessagePublisher<TestMessage> sender
    ) {
        this.sender = sender;
    }

    @GetMapping("/somedata")
    public ResponseEntity<String> random() {
        TestMessage message = TestMessage.builder()
                                         .name(UUID.randomUUID().toString().substring(0, 8))
                                         .location(UUID.randomUUID().toString().substring(0, 8))
                                         .build();

        sender.publish(SAMPLE_OUTPUT, message);

        return ResponseEntity.ok(String.format("Message `%s` Sent!", message));
    }
}
