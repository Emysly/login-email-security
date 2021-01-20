package com.emysilva.loginmailsecurity.dto;

import com.emysilva.loginmailsecurity.model.UserRole;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private UserRole userRole;
}
