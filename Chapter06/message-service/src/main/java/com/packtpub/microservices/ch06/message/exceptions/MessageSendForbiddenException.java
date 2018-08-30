package com.packtpub.microservices.ch06.message.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MessageSendForbiddenException extends Exception {
    public MessageSendForbiddenException(String message) { super(message); }
}