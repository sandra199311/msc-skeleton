package com.sandra.msc.serviceprovider.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sandra
 * @date 2019/9/23
 */
@RestController
public class TestController {

    @RequestMapping("/hi")
    public String hi() {

        return "hi";
    }

}
