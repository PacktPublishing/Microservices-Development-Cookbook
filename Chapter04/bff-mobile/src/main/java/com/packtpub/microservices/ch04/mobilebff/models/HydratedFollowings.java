package com.packtpub.microservices.ch04.mobilebff.models;

import java.util.List;

public class HydratedFollowings {
    private String username;

    private List<User> followings;

    public HydratedFollowings() {}

    public HydratedFollowings(String username, List<User>
            followings) {
        this.username = username;
        this.followings = followings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }
}
