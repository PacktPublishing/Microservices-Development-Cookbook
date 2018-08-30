package com.packtpub.microservices.ch05.message;

import com.packtpub.microservices.ch05.message.exceptions.MessageNotFoundException;
import com.packtpub.microservices.ch05.message.models.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MessageRepository {

    private Map<String, Message> messages;

    public MessageRepository() {
        messages = new HashMap<>();
    }

    public Message save(Message message) {
        UUID uuid = UUID.randomUUID();
        Message saved = new Message(uuid.toString(), message.getSender(), message.getRecipient(),
                message.getBody(), message.getAttachmentUri());
        messages.put(uuid.toString(), saved);
        return saved;
    }

    public Message get(String id) throws MessageNotFoundException {
        if (messages.containsKey(id)) {
            Message message = messages.get(id);
            return message;
        } else {
            throw new MessageNotFoundException("Message " + id + " could not be found");
        }
    }
}