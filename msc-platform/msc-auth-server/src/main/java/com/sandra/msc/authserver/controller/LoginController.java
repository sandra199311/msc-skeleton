package com.sandra.msc.authserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index() {

        return "welcome";
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam final String username, @RequestParam final String password) {

        return "login";
    }

}
