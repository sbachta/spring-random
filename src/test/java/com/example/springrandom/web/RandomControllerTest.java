package com.example.springrandom.web;

import com.example.springrandom.common.MessagePublisher;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class RandomControllerTest {

    private final MessagePublisher sender = mock(MessagePublisher.class);

    private final RandomController subject = new RandomController(sender);


    @Test
    void shouldReturnRandomString() {
        ResponseEntity<String> actual = subject.random();

        assertThat(actual.getBody()).isInstanceOf(String.class);
    }
}