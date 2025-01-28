package com.example.springrandom.web;

import com.example.springrandom.messaging.MessageSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RandomController {

    private final MessageSender sender;

    public RandomController(MessageSender sender) {
        this.sender = sender;
    }

    @GetMapping("/somedata")
    public ResponseEntity<String> random() {
        String message = UUID.randomUUID().toString().substring(0, 8);

        sender.send(message);
        sender.sendDelay("This is a delay message");

        return ResponseEntity.ok(String.format("Message `%s` Sent!", message));
    }
}
