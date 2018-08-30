package com.packtpub.microservices.ch04.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
    private String username;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public UserDetails() {}

    public UserDetails(String username, String displayName,
                String avatarUrl) {
        this.username = username;
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String toString() {
        return String.format("[UserDetails: %s, %s, %s]", username,
                displayName, avatarUrl);
    }
}
