package com.example.springrandom.messaging;

import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TestMessage {
    private String name;
    private String source;
    private boolean throwError;
}
