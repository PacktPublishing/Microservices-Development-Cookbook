package com.packtpub.microservices.ch06.auth.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationToken {

    @JsonProperty("auth_token")
    private String authToken;

    public AuthenticationToken() {}

    public AuthenticationToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
