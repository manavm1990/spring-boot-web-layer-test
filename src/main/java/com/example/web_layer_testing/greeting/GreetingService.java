package com.example.web_layer_testing.greeting;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hello, World!";
    }
}
