package com.example.springrandom.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class RandomControllerTest {

    private final RandomController subject = new RandomController();


    @Test
    void shouldReturnRandomString() {
        ResponseEntity<String> actual = subject.random();

        assertThat(actual.getBody()).isInstanceOf(String.class);
    }
}