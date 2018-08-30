package com.packtpub.microservices.ch04.message.controllers;

import com.packtpub.microservices.ch04.message.models.Message;
import com.packtpub.microservices.ch04.message.models.ResourceCollection;
import com.packtpub.microservices.ch04.message.models.UserFriendships;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MessageController {

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

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResourceCollection<Message> messages(@RequestParam(name="page", required=false, defaultValue="1") int page,
                                                HttpServletRequest request) {
        List<Message> messages = Stream.of(
                new Message("1234","paul", "veronica", "hello!"),
                new Message("5678","meghann", "paul", "hello!")
        ).collect(Collectors.toList());

        String nextUrl = String.format("%s?page=%d", request.getRequestURI(), page + 1);

        return new ResourceCollection<>(messages, page, nextUrl);
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public Message message(@PathVariable("id") String id) {
        return new Message(id, "paul", "veronica", "hi dad");
    }
}