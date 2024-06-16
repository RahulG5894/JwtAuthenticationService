package com.project.jwtauthentication.JwtAuthentication.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, RuntimeException {
        PrintWriter pw = response.getWriter();
        if(response.getStatus() == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
            pw.println("Invalid Login Tried" + authException.getMessage());
        }
    }
}
