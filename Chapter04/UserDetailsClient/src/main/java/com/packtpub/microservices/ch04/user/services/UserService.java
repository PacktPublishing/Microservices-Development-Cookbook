package com.packtpub.microservices.ch04.user.services;

import com.packtpub.microservices.ch04.user.models.UserDetails;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<UserDetails> getUserDetails(String username) {
        String url = String.format("http://localhost:8001/users/%s", username);
        UserDetails userDetails = restTemplate.getForObject(url, UserDetails.class);
        return CompletableFuture.completedFuture(userDetails);
    }
}
