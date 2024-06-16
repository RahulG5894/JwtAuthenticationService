package com.project.jwtauthentication.JwtAuthentication.controller;

import com.project.jwtauthentication.JwtAuthentication.model.User;
import com.project.jwtauthentication.JwtAuthentication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser() {
        return this.userService.getUsers();
    }

    @GetMapping("/login-user")
    public String getLoginUser(Principal principal) {
        return principal.getName();
    }
}