package com.project.jwtauthentication.JwtAuthentication.exceptionhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String message) {
        super(message);
    }
}
