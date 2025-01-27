package com.example.springrandom.common;

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
