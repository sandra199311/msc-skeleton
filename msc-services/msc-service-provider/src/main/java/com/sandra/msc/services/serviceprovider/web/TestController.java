package com.sandra.msc.services.serviceprovider.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sandra
 * @date 2019/9/23
 */
@RestController
public class TestController {

    @Value("${foo}")
    String foo;

    @Value("${server.port}")
    String serverPort;

    @Value("${spring.application.name}")
    String serverName;

    @Value("${useLocalCache}")
    private boolean useLocalCache;

    @RequestMapping("/hi")
    public String hi() {

        return "hi, from " + this.serverName + ":" + this.serverPort;
    }

    @RequestMapping("/foo")
    public String getFoo() {

        return this.foo;
    }

    @RequestMapping("/getUseLocalCache")
    public boolean getUseLocalCache() {

        return this.useLocalCache;
    }

}
