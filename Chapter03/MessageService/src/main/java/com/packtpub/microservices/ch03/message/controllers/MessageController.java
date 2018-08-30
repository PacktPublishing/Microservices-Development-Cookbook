package com.packtpub.microservices.ch03.message.controllers;

import com.packtpub.microservices.ch03.message.models.Message;
import com.packtpub.microservices.ch03.message.models.UserFriendships;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MessageController {

    @RequestMapping(
            path="/messages",
            method=RequestMethod.POST,
            produces="application/json")
    public ResponseEntity<Message> create(@RequestBody Message message) {
        List<String> friendships = getFriendsForUser(message.getFromUser(), message.getToUser());

        if (friendships.isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(message.getFromUser()).toUri();

        return ResponseEntity.created(location).build();
    }

    private List<String> getFriendsForUser(String username, String filter) {
        String url = "http://localhost:4567/friendships?username=" + username + "&filter=" + filter;
        RestTemplate template = new RestTemplate();
        UserFriendships friendships = template.getForObject(url, UserFriendships.class);
        return friendships.getFriendships();
    }
}