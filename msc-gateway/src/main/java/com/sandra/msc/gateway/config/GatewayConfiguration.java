package com.sandra.msc.gateway.config;

import com.sandra.msc.gateway.filter.HostAddrKeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关配置
 * @author sandra
 * @date 2019/9/23
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {

        return new HostAddrKeyResolver();
    }

    //通过代码进行路由配置，若要使用配置文件，则必须注释掉
    //    @Bean
//    public RouteLocator myRoutes(final RouteLocatorBuilder builder) {
//
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://localhost:80"))
//                .build();
//    }

}
