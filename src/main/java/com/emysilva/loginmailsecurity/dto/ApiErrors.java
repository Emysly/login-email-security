package com.emysilva.loginmailsecurity.dto;

import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ApiErrors {
    private String message;
    private HttpHeaders headers;
    private HttpStatus status;
    private WebRequest request;
    private LocalDateTime timeStamp;
}
