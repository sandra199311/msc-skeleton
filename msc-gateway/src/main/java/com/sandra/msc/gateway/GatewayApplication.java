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
public class GatewayApplication {

    public static void main(final String[] args) {

        SpringApplication.run(GatewayApplication.class, args);
    }

}
