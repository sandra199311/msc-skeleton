package com.sandra.msc.gateway.web;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${foo:foo}")
    String foo;

    @Value("${useLocalCache}")
    private boolean useLocalCache;

    @RequestMapping("/fallback")
    public Mono<String> fallback() {

        return Mono.just("fallback");
    }

    @RequestMapping("/foo")
    public String getFoo() {

        return this.foo;
    }

    @RequestMapping("/get")
    public boolean get() {

        return this.useLocalCache;
    }

}
