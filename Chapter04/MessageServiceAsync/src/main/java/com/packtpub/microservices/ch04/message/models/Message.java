package com.packtpub.microservices.ch04.message.models;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("item")
public class Message {
    private String id;
    private String toUser;
    private String fromUser;
    private String body;

    public Message(String id, String toUser, String fromUser, String body) {
        this.id = id;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}