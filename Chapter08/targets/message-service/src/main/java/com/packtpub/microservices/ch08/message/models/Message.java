package com.packtpub.microservices.ch08.message.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    private String id;
    private String sender;
    private String recipient;
    private String body;
    @JsonProperty("attachment_uri")
    private String attachmentUri;

    public Message() {}

    public Message(String sender, String recipient, String body, String attachmentUri) {
        this.sender = sender;
        this.recipient = recipient;
        this.body = body;
        this.attachmentUri = attachmentUri;
    }

    public Message(String id, String sender, String recipient, String body, String attachmentUri) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.body = body;
        this.attachmentUri = attachmentUri;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachmentUri() {
        return attachmentUri;
    }

    public void setAttachmentUri(String attachmentUri) {
        this.attachmentUri = attachmentUri;
    }
}