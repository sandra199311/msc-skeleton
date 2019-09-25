package com.sandra.msc.servicconsumer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sandra
 * @date 2019/9/23
 */
@RestController
public class TestController {

    @Value("${server.port}")
    String serverPort;

    @Value("${spring.application.name}")
    String serverName;

    @RequestMapping("/hi")
    public String hi() {

        return "hi, from " + this.serverName + ":" + this.serverPort;
    }

}
