package com.packtpub.microservices.ch03.message.controllers;

import com.packtpub.microservices.ch03.clientsideloadbalancing.UsersServiceConfiguration;
import com.packtpub.microservices.ch03.message.models.Message;
import com.packtpub.microservices.ch03.message.models.UserFriendships;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RibbonClient(name = "users-service", configuration = UsersServiceConfiguration.class)
@RestController
public class MessageController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(
            path="/messages",
            method=RequestMethod.POST,
            produces="application/json")
    public ResponseEntity<Message> create(@RequestBody Message message) throws ExecutionException, InterruptedException {

        CompletableFuture<Boolean> result1 = isFollowing(message.getFromUser(), message.getToUser());
        CompletableFuture<Boolean> result2 = isFollowing(message.getToUser(), message.getFromUser());

        CompletableFuture.allOf(result1, result2).join();

        // if both are not true, respond with a 403
        if (!(result1.get() && result2.get()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(message.getFromUser()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Async
    public CompletableFuture<Boolean> isFollowing(String fromUser, String toUser) {

        String url = String.format(
                "http://localhost:4567/followings?user=%s&filter=%s",
                fromUser, toUser);

        RestTemplate template = new RestTemplate();
        UserFriendships followings = template.getForObject(url, UserFriendships.class);

        return CompletableFuture.completedFuture(
                followings.getFriendships().isEmpty()
        );
    }
}