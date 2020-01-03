package com.sandra.msc.authserver.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 受保护资源访问权限控制
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/hi").permitAll().anyRequest().authenticated();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers()
                .anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/login/**", "/oauth/**")
                .permitAll()
                // 监控端点内部放行
                .requestMatchers(EndpointRequest.toAnyEndpoint())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

}
