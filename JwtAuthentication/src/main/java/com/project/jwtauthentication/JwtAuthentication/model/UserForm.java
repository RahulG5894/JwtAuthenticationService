package com.project.jwtauthentication.JwtAuthentication.model;

import lombok.Data;

@Data
public class UserForm {
    private String name;
    private String email;
    private String password;
}
