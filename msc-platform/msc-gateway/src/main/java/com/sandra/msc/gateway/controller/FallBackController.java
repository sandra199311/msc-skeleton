package com.sandra.msc.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author sandra
 * @date 2019/9/27
 */
@RestController
public class FallBackController {

    @RequestMapping("/fallback")
    public Mono<String> fallback() {

        return Mono.just("hi, fallback");
    }

}
