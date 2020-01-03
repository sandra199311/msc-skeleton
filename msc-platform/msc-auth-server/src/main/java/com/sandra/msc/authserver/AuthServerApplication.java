package com.sandra.msc.authserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * UaaApplication
 *
 * @author sandra
 * @date 2019年12月10日
 */
@MapperScan(basePackages = "com.sandra.msc.authserver.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class AuthServerApplication {

    public static void main(final String[] args) {

        SpringApplication.run(AuthServerApplication.class, args);
    }

}
