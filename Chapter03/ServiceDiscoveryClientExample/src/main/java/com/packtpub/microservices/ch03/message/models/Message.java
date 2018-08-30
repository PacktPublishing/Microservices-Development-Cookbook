package com.packtpub.microservices.ch03.message.models;

public class Message {

    private String toUser;
    private String fromUser;
    private String body;

    public Message() {}

    public Message(String toUser, String fromUser, String body) {
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.body = body;
    }

    public String getToUser() {
        return toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getBody() {
        return body;
    }
}