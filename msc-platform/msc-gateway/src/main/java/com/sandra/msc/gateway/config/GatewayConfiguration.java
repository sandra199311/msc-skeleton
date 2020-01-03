package com.sandra.msc.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandra.msc.gateway.filter.HostAddrKeyResolver;

/**
 * 网关配置
 * 
 * @author sandra
 * @date 2019/9/23
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {

        return new HostAddrKeyResolver();
    }

}
