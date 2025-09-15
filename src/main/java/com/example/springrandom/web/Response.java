package com.example.springrandom.web;

import com.example.springrandom.messaging.TestMessage;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private List<TestMessage> messages;
    private String            note;
}
