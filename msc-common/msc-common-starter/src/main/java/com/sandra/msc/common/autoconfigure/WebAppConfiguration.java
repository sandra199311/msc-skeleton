package com.sandra.msc.common.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/**
 * 
 * WebAppConfiguration
 *
 * @author sandra
 * @date 2020年1月2日
 */
@Configuration
public class WebAppConfiguration {

    @Bean
    public RequestContextListener requestContextListener() {

        return new RequestContextListener();
    }
}
