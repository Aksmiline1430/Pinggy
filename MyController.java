package com.example.Request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String handleRequest() {
        String authToken = CustomAuthenticationFilter.getCurrentAuthToken();
        
        if (authToken != null) {
            return "PinggyAuthHeader value: " + authToken;
        } else {
            // If the header value is not found in the ThreadLocal storage
            return "PinggyAuthHeader value not found";
        }
    }
}
