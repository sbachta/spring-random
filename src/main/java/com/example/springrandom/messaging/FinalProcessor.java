package com.example.springrandom.messaging;

import com.example.springrandom.common.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static com.example.springrandom.common.MessageConstants.FINAL_INPUT;

@Component
public class FinalProcessor implements Processor<TestMessage> {

    @Override
    @Bean(FINAL_INPUT)
    public Consumer<Message<TestMessage>> read() {
        return message -> {
            System.out.println("Received final <" + message + ">");
        };
    }
}
