package com.example.springrandom.common;

@FunctionalInterface
public interface Publisher<MESSAGE> {

    void publish(String exchange, MESSAGE message);
}
