package com.packtpub.microservices.ch09.message.clients;

import com.packtpub.microservices.ch09.message.models.UserFriendships;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SocialGraphClient {
    private String baseUrl;

    private CircuitBreaker circuitBreaker;

    public SocialGraphClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.circuitBreaker = CircuitBreaker.ofDefaults("socialGraphClient");
    }

    public List<String> getFriendships(String username) {

        CheckedFunction0<UserFriendships> decoratedSupplier = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> {
            String requestUrl = baseUrl + "/friendships/" + username;
            RestTemplate template = new RestTemplate();
            return template.getForObject(requestUrl, UserFriendships.class);
        });

        Try<UserFriendships> result = Try.of(decoratedSupplier);

        return result.getOrElse(new UserFriendships(username)).getFriendships();
    }
}
