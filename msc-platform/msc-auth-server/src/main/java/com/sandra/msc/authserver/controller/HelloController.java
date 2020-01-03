package com.sandra.msc.authserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    String serverPort;

    @Value("${spring.application.name}")
    String serverName;

    @GetMapping("/hi")
    public String hi() {

        return "hi, from " + serverName + ":" + serverPort;
    }

}
