package com.packtpub.microservices.ch03.message.controllers;

import com.packtpub.microservices.ch03.message.models.Message;
import com.packtpub.microservices.ch03.message.models.UserFriendships;
import com.packtpub.microservices.ch03.servicediscovery.clients.UsersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    @Autowired
    private UsersClient usersClient;

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

        List<String> friends = usersClient.getFollowings(fromUser)
                .stream()
                .filter(toUser::equals)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(friends.isEmpty());
    }
}