package com.packtpub.microservices.ch04.mobilebff.services;

import com.packtpub.microservices.ch04.mobilebff.models.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UsersService {

    private final RestTemplate restTemplate;

    public UsersService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> getUserDetails(String username) {
        String url = String.format("http://localhost:4568/users/%s", username);
        User user = restTemplate.getForObject(url, User.class);
        return CompletableFuture.completedFuture(user);
    }
}