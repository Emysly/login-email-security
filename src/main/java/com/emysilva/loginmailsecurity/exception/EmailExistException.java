package com.emysilva.loginmailsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailExistException extends RuntimeException {
    public EmailExistException(String message) {
        super(message);
    }
}
