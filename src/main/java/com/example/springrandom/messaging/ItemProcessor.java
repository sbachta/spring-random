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

import static com.example.springrandom.common.MessageConstants.ITEM_INPUT;
import static com.example.springrandom.common.MessageConstants.SAMPLE_OUTPUT;

@Slf4j
@Component
public class ItemProcessor implements Processor<TestMessage> {

    private final MessagePublisher<TestMessage> sender;

    public ItemProcessor(MessagePublisher<TestMessage> sender) {
        this.sender = sender;
    }

    @Override
    @Bean(ITEM_INPUT)
    public Consumer<Message<TestMessage>> read() {
        return message -> {
            var routeTo = message.getHeaders().getOrDefault("routeTo", "");

            if (routeTo.equals("start")){
                log.info("Item message received `{}` at `{}`", message.getPayload(), LocalDateTime.now());

                sender.publish(SAMPLE_OUTPUT, MessageBuilder.withPayload(TestMessage.builder()
                                                                                    .name(message.getPayload().getName())
                                                                                    .source("item")
                                                                                    .build())
                                                            .setHeader("routeTo", "final")
                                                            .build());

                log.info("Item published at `{}`", LocalDateTime.now());
            }
        };
    }
}
