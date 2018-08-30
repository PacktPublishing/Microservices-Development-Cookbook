package com.packtpub.microservices.ch06.auth.controllers;

import com.packtpub.microservices.ch06.auth.data.UserCredentialRepository;
import com.packtpub.microservices.ch06.auth.exceptions.InvalidCredentialsException;
import com.packtpub.microservices.ch06.auth.models.AuthenticationToken;
import com.packtpub.microservices.ch06.auth.models.UserCredential;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@RestController
public class UserCredentialController {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${secretKey}")
    private String keyString;

    private String encodeJwt(String userId) {
        Key key = new SecretKeySpec(
                DatatypeConverter.parseBase64Binary(keyString),
                SignatureAlgorithm.HS256.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(userId)
                .setSubject(userId)
                .setIssuer("authentication-service")
                .signWith(SignatureAlgorithm.HS256, key);

        return builder.compact();
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST, produces = "application/json")
    public AuthenticationToken register(@RequestParam String email, @RequestParam String password, @RequestParam String passwordConfirmation) throws InvalidCredentialsException {
        if (!password.equals(passwordConfirmation)) {
            throw new InvalidCredentialsException("Password and confirmation do not match");
        }

        UserCredential cred = new UserCredential(email);
        cred.setPassword(passwordEncoder.encode(password));
        userCredentialRepository.save(cred);

        String jws = encodeJwt(cred.getId());
        return new AuthenticationToken(jws);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = "application/json")
    public AuthenticationToken login(@RequestParam String email, @RequestParam String password) throws InvalidCredentialsException {
        UserCredential user = userCredentialRepository.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Username or password invalid");
        }

        String jws = encodeJwt(user.getId());
        return new AuthenticationToken(jws);
    }
}
