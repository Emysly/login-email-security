package com.emysilva.loginmailsecurity.service;

import com.emysilva.loginmailsecurity.model.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {
     void saveConfirmationToken(ConfirmationToken confirmationToken);
     Optional<ConfirmationToken> getToken(String token);
     void setConfirmedAt(String token);

     boolean enableAppUser(String email);

     boolean confirmToken(String token);
}
