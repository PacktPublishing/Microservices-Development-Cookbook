package com.packtpub.microservices.ch04.user.services;

import com.packtpub.microservices.ch04.user.models.Followings;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class SocialService {
    private final RestTemplate restTemplate;

    public SocialService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Followings> getFollowings(String username) {
        String url = String.format("http://localhost:8000/followings/%s", username);
        Followings followings = restTemplate.getForObject(url, Followings.class);
        return CompletableFuture.completedFuture(followings);
    }
}
