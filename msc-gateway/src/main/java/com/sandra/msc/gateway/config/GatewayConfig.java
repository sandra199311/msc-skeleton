package com.sandra.msc.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * @author sandra
 * @date 2019/9/23
 */
//@Configuration
public class GatewayConfig {

    //    @Bean
    public RouteLocator myRoutes(final RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:80"))
                .build();
    }

}
