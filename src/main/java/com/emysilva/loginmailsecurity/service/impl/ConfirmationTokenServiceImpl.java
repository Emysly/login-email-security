package com.emysilva.loginmailsecurity.service.impl;

import com.emysilva.loginmailsecurity.exception.TokenException;
import com.emysilva.loginmailsecurity.model.AppUser;
import com.emysilva.loginmailsecurity.model.ConfirmationToken;
import com.emysilva.loginmailsecurity.repository.ConfirmationTokenRepository;
import com.emysilva.loginmailsecurity.repository.UserRepository;
import com.emysilva.loginmailsecurity.service.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final UserRepository userRepository;
    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public void setConfirmedAt(String token) {
        ConfirmationToken confirmationToken = getToken(token).get();
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenRepository.save(confirmationToken);
    }

    @Override
    public boolean enableAppUser(String email) {
        AppUser user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("user email not found"));
        user.setEnabled(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean confirmToken(String token) {
        ConfirmationToken user = confirmationTokenRepository.findByToken(token).get();
        LocalDateTime expiredAt = user.getExpiresAt();

        return expiredAt.isBefore(LocalDateTime.now());
    }
}
