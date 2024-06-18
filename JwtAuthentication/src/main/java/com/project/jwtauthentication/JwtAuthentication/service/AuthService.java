package com.project.jwtauthentication.JwtAuthentication.service;

import com.project.jwtauthentication.JwtAuthentication.model.User;
import com.project.jwtauthentication.JwtAuthentication.userRepository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> mayBeUserOptional = userRepository.findByEmailIgnoreCase(email);
        if(mayBeUserOptional.isEmpty()) {
            logger.info("User with required email not found");
            throw new UsernameNotFoundException("User not found!");
        }
        User user = mayBeUserOptional.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

}
