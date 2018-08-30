package com.packtpub.microservices.ch05.userservice.controllers;

import com.packtpub.microservices.ch05.userservice.db.UserRepository;
import com.packtpub.microservices.ch05.userservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/users", method = RequestMethod.POST, produces = "application/json")
    public User create(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> getById(@PathVariable("id") String id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK)).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}