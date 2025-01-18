package com.example.springrandom.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {


    @GetMapping("/somedata")
    public ResponseEntity<String> random() {
        return ResponseEntity.ok("something");
    }
}
