package com.emysilva.loginmailsecurity.controller;

import com.emysilva.loginmailsecurity.dto.SignUpResponse;
import com.emysilva.loginmailsecurity.dto.SignupRequest;
import com.emysilva.loginmailsecurity.model.AppUser;
import com.emysilva.loginmailsecurity.model.ConfirmationToken;
import com.emysilva.loginmailsecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth/")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<SignUpResponse> register(@Valid @RequestBody SignupRequest signupRequest) throws MessagingException {
         ConfirmationToken user = userService.signup(signupRequest);

         return ResponseEntity.ok().body(new SignUpResponse(user.getAppUser().getName(),
                 user.getAppUser().getEmail(), user.getAppUser().getUserRole(), user.getToken()));
    }

    @GetMapping("confirm")
    public String confirmToken(@RequestParam String token) {
        String confirmed = userService.confirmToken(token);

        return confirmed;
    }
}
