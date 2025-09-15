package com.example.springrandom.web;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.messaging.TestMessage;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.example.springrandom.common.MessageConstants.SAMPLE_OUTPUT;

@Slf4j
@RestController
public class RandomController {

    private final MessagePublisher<TestMessage> sender;
    private final Faker faker = new Faker();

    public RandomController(
            final MessagePublisher<TestMessage> sender
    ) {
        this.sender = sender;
    }

    @GetMapping("/publish-data")
    public ResponseEntity<Response> random() {
        String name = UUID.randomUUID().toString().substring(0, 8);

        TestMessage message = TestMessage.builder()
                                         .name(name)
                                         .source("endpoint")
                                         .throwError(name.contains("5"))
                                         .build();

        sender.publish(SAMPLE_OUTPUT, MessageBuilder.withPayload(message).setHeader("routeTo", "start").build());

        log.info("Sent `{}`", message);
        return ResponseEntity.ok(Response.builder().messages(List.of(message)).note("Success").build());
    }

    @GetMapping("/some-data")
    public ResponseEntity<Response> some() {
        Response result = Response.builder()
                                  .messages(constructMessages())
                                  .note(faker.random().nextBoolean() ? "Success" : "Failed")
                                  .build();

        log.info("Some Data`{}`", result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list-data")
    public List<TestMessage> list() {
        List<TestMessage> result = constructMessages();
        log.info("List Data `{}`", result);
        return result;
    }

    private List<TestMessage> constructMessages() {
        List<TestMessage> messages = new java.util.ArrayList<>(Collections.emptyList());
        int                     i        = 0;
        int                     max      = faker.random().nextInt(0, 10);

        do {
            messages.add(TestMessage.builder()
                                    .name(faker.name().fullName())
                                    .source(faker.futurama().quote())
                                    .throwError(faker.random().nextBoolean())
                                    .build());
        } while (++i < max);
        return messages;
    }
}
