package com.packtpub.microservices.ch04.user.models;

import java.util.List;

public class Followings {
    private String username;
    private List<String> followings;

    public Followings() {}

    public Followings(String username, List<String> followings) {
        this.username = username;
        this.followings = followings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getFollowings() {
        return followings;
    }

    public void setFollowings(List<String> followings) {
        this.followings = followings;
    }

    public String toString() {
        return String.format("[Followings for username: %s - %s]",
                username, followings);
    }
}
