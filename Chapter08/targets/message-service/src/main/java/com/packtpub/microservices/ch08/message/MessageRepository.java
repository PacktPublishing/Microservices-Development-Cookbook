package com.packtpub.microservices.ch08.message;

import com.packtpub.microservices.ch08.message.exceptions.MessageNotFoundException;
import com.packtpub.microservices.ch08.message.models.Message;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MessageRepository {

    private ConcurrentHashMap<String, Message> messages;
    private ConcurrentHashMap<String, List<Message>> inbox;

    public MessageRepository() {
        messages = new ConcurrentHashMap<>();
        inbox = new ConcurrentHashMap<>();
    }

    public Message save(Message message) {
        UUID uuid = UUID.randomUUID();
        Message saved = new Message(uuid.toString(), message.getSender(), message.getRecipient(),
                message.getBody(), message.getAttachmentUri());
        messages.put(uuid.toString(), saved);
        List<Message> userInbox = inbox.getOrDefault(message.getRecipient(), new ArrayList<>());
        userInbox.add(saved);
        inbox.put(message.getRecipient(), userInbox);
        return saved;
    }

    public Message get(String id) throws MessageNotFoundException {
        if (messages.containsKey(id)) {
            return messages.get(id);
        } else {
            throw new MessageNotFoundException("Message " + id + " could not be found");
        }
    }

    public List<Message> getByUser(String userId) {
        return inbox.getOrDefault(userId, new ArrayList<>());
    }
}