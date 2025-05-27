package com.example.springrandom.messaging;

import com.example.springrandom.common.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import static com.example.springrandom.common.MessageConstants.RETRY_INPUT;

@Slf4j
@Component
public class RetryProcessor implements Processor<TestMessage> {

    @Override
    @Bean(RETRY_INPUT)
    public Consumer<Message<TestMessage>> read() {
        return message -> {
            log.info("Retry Message received `{}` at `{}`", message.getPayload(), LocalDateTime.now());
        };
    }
}
