package com.packtpub.microservices.ch02.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packtpub.microservices.ch02.gateway.commands.*;
import com.packtpub.microservices.ch02.gateway.models.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@RestController
public class MainController {

    @RequestMapping(value = "/message_details/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, HashMap<String, String>> messageDetails(@PathVariable String id)
            throws ExecutionException, InterruptedException, IOException {

        Map<String, HashMap<String, String>> result = new HashMap<>();
        HashMap<String, String> innerResult = new HashMap<>();

        Message message = new MessageCommand(id).run();
        String messageId = message.getId();

        Future<String> user = new UserCommand(message.getFromUserId()).queue();
        Future<String> attachments = new AttachmentCommand(messageId).queue();
        Future<String> likes = new LikeCommand(messageId).queue();
        Future<String> comments = new CommentCommand(messageId).queue();

        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, message);

        innerResult.put("message", writer.toString());
        innerResult.put("from_user", user.get());
        innerResult.put("attachments", attachments.get());
        innerResult.put("comments", comments.get());
        innerResult.put("likes", likes.get());

        result.put("message_details", innerResult);

        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }
}