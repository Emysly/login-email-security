package com.emysilva.loginmailsecurity.dto;

import com.emysilva.loginmailsecurity.model.UserRole;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SignUpResponse {
    private String username;
    private String email;
    private UserRole userRole;
    private String token;

}
