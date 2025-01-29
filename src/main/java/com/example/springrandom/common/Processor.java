package com.example.springrandom.common;

import org.springframework.messaging.Message;

import java.util.function.Consumer;

@FunctionalInterface
public interface Processor<MESSAGE> {

    Consumer<Message<MESSAGE>> read();
}
