package com.example.springrandom.messaging;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.common.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import static com.example.springrandom.common.MessageConstants.FINAL_INPUT;

@Slf4j
@Component
public class FinalProcessor implements Processor<TestMessage> {

    private final MessagePublisher<TestMessage> sender;

    public FinalProcessor(MessagePublisher<TestMessage> sender) {
        this.sender = sender;
    }

    @Override
    @Bean(FINAL_INPUT)
    public Consumer<Message<TestMessage>> read() {
        return message -> {
            var routeTo = message.getHeaders().getOrDefault("routeTo", "");

            if (routeTo.equals("final")) {
                log.info("Received final `{}` at `{}`", message.getPayload(), LocalDateTime.now());
            }

        };
    }
}
