package com.sandra.msc.services.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandra.msc.services.consumer.feign.ServiceProviderClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author sandra
 * @date 2019/9/23
 */
@RestController
@Api("测试")
public class TestController {

    @Value("${server.port}")
    String serverPort;

    @Value("${spring.application.name}")
    String serverName;

    @Autowired
    ServiceProviderClient serviceProviderClient;

    @ApiOperation(value = "hi", httpMethod = "GET")
    @ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class) })
    @GetMapping("/hi")
    public String hi() {

        return "hi, from " + serverName + ":" + serverPort;
    }

    @GetMapping("/testFeign")
    public String testFeign() {

        return serviceProviderClient.hi();

    }
}
