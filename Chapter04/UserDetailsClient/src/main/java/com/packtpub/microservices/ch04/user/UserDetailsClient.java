package com.packtpub.microservices.ch04.user;

import com.packtpub.microservices.ch04.user.models.UserDetails;
import com.packtpub.microservices.ch04.user.services.SocialService;
import com.packtpub.microservices.ch04.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@SpringBootApplication
public class UserDetailsClient implements CommandLineRunner {

    public UserDetailsClient() {}

    @Autowired
    private SocialService socialService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserDetailsClient.class, args);
    }

    public CompletableFuture<List<UserDetails>>
    getFollowingDetails(String username) {
        return socialService.getFollowings(username).thenApply(f ->
                f.getFollowings().stream().map(u ->userService.
                        getUserDetails(u)).map(CompletableFuture::join).
                        collect(Collectors.toList()));
    }

    @Override
    public void run(String... args) throws Exception {
        Future<List<UserDetails>> users = getFollowingDetails("paulosman");
        System.out.println(users.get());
        System.exit(0);
    }
}
