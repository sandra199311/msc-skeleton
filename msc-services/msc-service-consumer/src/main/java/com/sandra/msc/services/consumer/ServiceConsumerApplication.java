package com.sandra.msc.services.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sandra
 * @date 2019/9/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class ServiceConsumerApplication {

    public static void main(final String[] args) {

        SpringApplication.run(ServiceConsumerApplication.class, args);
    }

}
