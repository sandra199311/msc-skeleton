package com.sandra.msc.services.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * HelloController
 *
 * @author sandra
 * @date 2020年1月2日
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String serverPort;

    @Value("${spring.application.name}")
    String serverName;

    @GetMapping(value = "/hi")
    public String hi() {

        return "hi, from " + serverName + ":" + serverPort;
    }

    @GetMapping(value = "/test")
    public String test() {

        return "test";
    }

}
