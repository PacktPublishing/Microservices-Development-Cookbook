package com.packtpub.microservices.ch06.attachment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No attachment(s) found")
public class AttachmentNotFoundException extends RuntimeException {}
