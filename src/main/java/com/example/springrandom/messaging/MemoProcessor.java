package com.example.springrandom.messaging;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.common.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static com.example.springrandom.common.MessageConstants.MEMO_INPUT;
import static com.example.springrandom.common.MessageConstants.SAMPLE_OUTPUT_DELAY;

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
            System.out.println("Received memo <" + message + ">");
            sender.publish(SAMPLE_OUTPUT_DELAY, message.getPayload());
        };
    }
}
