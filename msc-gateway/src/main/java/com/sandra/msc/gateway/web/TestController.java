package com.sandra.msc.gateway.web;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author sandra
 * @date 2019/9/23
 */
@RestController
@RefreshScope
public class TestController {

    @RequestMapping("/fallback")
    public Mono<String> fallback() {

        return Mono.just("fallback");
    }

}
