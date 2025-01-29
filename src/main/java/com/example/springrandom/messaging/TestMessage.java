package com.example.springrandom.messaging;

import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TestMessage {
    private String name;
    private String location;
}
