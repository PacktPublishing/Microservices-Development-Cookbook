package com.packtpub.microservices.ch06.auth.data;

import com.packtpub.microservices.ch06.auth.models.UserCredential;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialRepository extends CrudRepository<UserCredential, String> {
    UserCredential findByEmail(String email);
}
