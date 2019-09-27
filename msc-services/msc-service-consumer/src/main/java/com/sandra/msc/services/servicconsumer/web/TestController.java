package com.sandra.msc.services.servicconsumer.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "hi", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS", response = String.class)})
    @RequestMapping("/hi")
    public String hi() {

        return "hi, from " + this.serverName + ":" + this.serverPort;
    }

}
