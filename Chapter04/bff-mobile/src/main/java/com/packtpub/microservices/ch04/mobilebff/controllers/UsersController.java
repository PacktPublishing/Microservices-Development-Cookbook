package com.packtpub.microservices.ch04.mobilebff.controllers;

import com.packtpub.microservices.ch04.mobilebff.models.HydratedFollowings;
import com.packtpub.microservices.ch04.mobilebff.models.User;
import com.packtpub.microservices.ch04.mobilebff.services.SocialGraphService;
import com.packtpub.microservices.ch04.mobilebff.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class UsersController {

    @Autowired
    private SocialGraphService socialGraphService;

    @Autowired
    private UsersService userService;

    @RequestMapping(path = "/users/{username}/followings", method = RequestMethod.GET)
    public HydratedFollowings getFollowings(@PathVariable String username)
            throws ExecutionException, InterruptedException {
        CompletableFuture<List<User>> users = socialGraphService.getFollowing
                (username).thenApply(f -> f.getFollowings().stream().map(
                u -> userService.getUserDetails(u)).map(
                CompletableFuture::join).collect(Collectors.toList()));
        return new HydratedFollowings(username, users.get());
    }
}