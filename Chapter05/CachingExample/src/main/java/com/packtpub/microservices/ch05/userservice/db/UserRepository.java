package com.packtpub.microservices.ch05.userservice.db;

import com.packtpub.microservices.ch05.userservice.models.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    @Override
    @Cacheable(value = "users", key = "#id")
    Optional<User> findById(String id);

    @Override
    @CachePut(value = "users", key = "#user.id")
    User save(User user);
}