package com.sandra.msc.services.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sandra
 * @date 2019/9/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderApplication {

    public static void main(final String[] args) {

        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
