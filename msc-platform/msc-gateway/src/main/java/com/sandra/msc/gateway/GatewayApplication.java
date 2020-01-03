package com.sandra.msc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sandra
 * @date 2019/9/23
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableWebFluxSecurity
public class GatewayApplication {

    public static void main(final String[] args) {

        SpringApplication.run(GatewayApplication.class, args);
    }

    //    @Bean
    //    SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity http) {
    //
    //        http.authorizeExchange().pathMatchers("/hi").permitAll().anyExchange().authenticated();
    //
    //        http.oauth2ResourceServer().jwt();
    //
    //        return http.build();
    //    }

}
