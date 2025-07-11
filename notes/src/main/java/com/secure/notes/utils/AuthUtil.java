package com.secure.notes.utils;

import com.secure.notes.models.User;
import com.secure.notes.repositories.UserRepository;
import com.secure.notes.services.UserService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {
    @Autowired
    UserRepository userRepository;
    public Long loggedInUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User users=userRepository.findByUserName(authentication.getName()).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return users.getUserId();
    }

    public User loggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUserName(authentication.getName()).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
