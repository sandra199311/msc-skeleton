package com.sandra.msc.services.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import com.sandra.msc.common.core.constant.Constant;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    ResourceServerTokenServices tokenService;

    /**
     * 受保护资源访问权限控制
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/hi", Constant.SWAGGER_API_URI).permitAll().anyRequest().authenticated();
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {

        resources.tokenServices(tokenService);
    }

}
