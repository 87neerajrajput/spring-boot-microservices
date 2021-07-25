package com.jpmchase.tpm.userservice.controller;

import com.jpmchase.tpm.userservice.entity.User;
import com.jpmchase.tpm.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final String USER_SERVICE = "userService";
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") long userId) {
        log.info("Inside Controller getUser method.");
        return userService.getUser(userId);
    }

    private ResponseEntity<String> testFallBack(Exception e){
        return new ResponseEntity<String>("In fallback method", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
