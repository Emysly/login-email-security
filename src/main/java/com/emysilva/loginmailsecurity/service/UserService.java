package com.emysilva.loginmailsecurity.service;

import com.emysilva.loginmailsecurity.dto.SignupRequest;
import com.emysilva.loginmailsecurity.model.ConfirmationToken;

import javax.mail.MessagingException;

public interface UserService {
    ConfirmationToken signup(SignupRequest signupRequest) throws MessagingException;
    String confirmToken(String token);
}
