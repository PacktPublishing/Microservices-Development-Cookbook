package com.packtpub.microservices.ch02.gateway.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.packtpub.microservices.ch02.gateway.models.Message;
import org.springframework.web.client.RestTemplate;

public class MessageCommand extends HystrixCommand<Message> {

    private final String id;

    public MessageCommand(String id) {
        super(HystrixCommandGroupKey.Factory.asKey("MessageGroup"));
        this.id = id;
    }

    @Override
    public Message run() {
        RestTemplate template = new RestTemplate();
        String messageServiceUrl = "http://localhost:4567/message/" + id;
        Message message = template.getForObject(messageServiceUrl, Message.class);
        return message;
    }
}