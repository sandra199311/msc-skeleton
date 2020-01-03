package com.sandra.msc.services.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.sandra.msc.common.core.constant.Constant;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 受保护资源访问权限控制
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/hi", Constant.SWAGGER_API_URI).permitAll().anyRequest().authenticated();
    }

}
