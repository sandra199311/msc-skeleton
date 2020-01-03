package com.sandra.msc.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author sandra
 * @date 2019/9/26
 */
public class HostAddrKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(final ServerWebExchange exchange) {

        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}
