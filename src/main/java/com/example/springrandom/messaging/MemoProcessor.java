package com.example.springrandom.messaging;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.common.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import static com.example.springrandom.common.MessageConstants.*;

@Slf4j
@Component
public class MemoProcessor implements Processor<TestMessage> {

    private final MessagePublisher<TestMessage> sender;

    public MemoProcessor(
            final MessagePublisher<TestMessage> sender
    ) {
        this.sender = sender;
    }

    @Override
    @Bean(MEMO_INPUT)
    public Consumer<Message<TestMessage>> read() {
        return message -> {
            var routeTo = message.getHeaders().getOrDefault("routeTo", "");

            if (routeTo.equals("start")){
                log.info("Memo message received `{}` at `{}`", message.getPayload(), LocalDateTime.now());

                if(message.getPayload().isThrowError()) {
                    throw new RuntimeException();
                }
                else {
                    sender.publish(SAMPLE_OUTPUT, MessageBuilder.withPayload(TestMessage.builder()
                                                                                        .name(message.getPayload().getName())
                                                                                        .source("memo")
                                                                                        .build())
                                                                .setHeader("routeTo", "final")
                                                                .build());

                    log.info("Memo published at `{}`", LocalDateTime.now());
                }
            }

        };
    }
}
