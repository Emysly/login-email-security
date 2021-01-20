package com.emysilva.loginmailsecurity.service.impl;

import com.emysilva.loginmailsecurity.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String emailText) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(emailText, true);
        helper.setFrom("hello@emysilva.com");
        helper.setTo(to);
        helper.setSubject("confirm your email");
        mailSender.send(mimeMessage);
    }
}
