package com.packtpub.microservices.ch03.message.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packtpub.microservices.ch03.message.models.Message;
import com.packtpub.microservices.ch03.message.models.UserFriendships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class MessageController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

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

        publishMessageEvent(message);
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

    private void publishMessageEvent(Message message) {
        try {
            String data = objectMapper.writeValueAsString(message);
            ListenableFuture<SendResult> result = kafkaTemplate.send("messages", data);
            result.addCallback(new ListenableFutureCallback<SendResult>() {
                @Override
                public void onFailure(Throwable ex) {
                    System.err.println("Failed to emit message event: " + ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult result) {
                    System.out.println("Successfully published message event");
                }
            });
        } catch (JsonProcessingException e) {
            System.err.println("Error processing json: " + e.getMessage());
        }
    }
}
