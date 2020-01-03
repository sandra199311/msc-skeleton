package com.sandra.msc.authserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandra.msc.authserver.entity.User;
import com.sandra.msc.authserver.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public Principal getUser(final Principal principal) {

        return principal;
    }

    @GetMapping("/{userId}")
    public User getInfo(@PathVariable final String userId) {

        final User userInfoEntity = userService.getById(userId);
        return userInfoEntity;
    }
}
