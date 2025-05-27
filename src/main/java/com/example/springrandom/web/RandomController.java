package com.example.springrandom.web;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.messaging.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.springrandom.common.MessageConstants.SAMPLE_OUTPUT;

@Slf4j
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
        String name = UUID.randomUUID().toString().substring(0, 8);

        TestMessage message = TestMessage.builder()
                                         .name(name)
                                         .source("endpoint")
                                         .throwError(name.contains("5"))
                                         .build();

        sender.publish(SAMPLE_OUTPUT, MessageBuilder.withPayload(message).setHeader("routeTo", "start").build());

        log.info("Sent `{}`", message);
        return ResponseEntity.ok(String.format("Message `%s` Sent!", message));
    }
}
