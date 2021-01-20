package com.emysilva.loginmailsecurity.service;

import javax.mail.MessagingException;

public interface EmailSenderService {
    void sendEmail(String to, String emailText) throws MessagingException;
}
