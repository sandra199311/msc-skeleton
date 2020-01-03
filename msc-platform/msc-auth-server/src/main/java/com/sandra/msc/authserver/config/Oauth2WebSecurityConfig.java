package com.sandra.msc.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sandra.msc.authserver.security.CostomUserServiceDetail;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(2)
public class Oauth2WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CostomUserServiceDetail userServiceDetail;

    /**
     * 配置oauth endpoint与登录接口访问权限
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.requestMatchers()
                .antMatchers("/oauth/authorize", "/oauth/confirm_access", "/oauth/error", "/login", "/logout")
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true);

    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userServiceDetail).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
