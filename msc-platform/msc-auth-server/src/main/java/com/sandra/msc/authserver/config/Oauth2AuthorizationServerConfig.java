package com.sandra.msc.authserver.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.sandra.msc.authserver.security.CostomJwtAccessTokenConverter;
import com.sandra.msc.authserver.security.CostomUserServiceDetail;

/**
 * 
 * Oauth2AuthorizationServerConfig
 *
 * @author sandra
 * @date 2019年12月30日
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private CostomUserServiceDetail userServiceDetail;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetails());

    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.tokenStore(tokenStore())
                .tokenEnhancer(jwtTokenEnhancer())
                .approvalStore(approvalStore())
                .authorizationCodeServices(authorizationCodeServices())
                .authenticationManager(authenticationManager)
                .userDetailsService(userServiceDetail)
                .reuseRefreshTokens(true);

    }

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()").allowFormAuthenticationForClients();
    }

    @Bean
    public ApprovalStore approvalStore() {

        return new JdbcApprovalStore(dataSource);

    }

    @Bean
    public TokenStore tokenStore() {

        return new RedisTokenStore(redisConnectionFactory);

    }

    /**
     * 配置ClientDetailsService
     * 
     * @return ClientDetailsService
     */
    @Bean
    public ClientDetailsService clientDetails() {

        final JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        jdbcClientDetailsService.setPasswordEncoder(passwordEncoder);
        return jdbcClientDetailsService;
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {

        return new JdbcAuthorizationCodeServices(dataSource);
    }

    /**
     * 定义jwt的生成方式
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {

        final JwtAccessTokenConverter jwtAccessTokenConverter = new CostomJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("123");

        return jwtAccessTokenConverter;
    }

    //    @Bean
    //    private DefaultTokenServices tokenService() {
    //
    //        final DefaultTokenServices tokenService = new DefaultTokenServices();
    //        tokenService.setSupportRefreshToken(true);
    //
    //        final DefaultTokenServices tokenServices = new DefaultTokenServices();
    //        tokenServices.setTokenStore(tokenStore());
    //        tokenServices.setTokenEnhancer(jwtAccessTokenConverter());
    //        tokenServices.setSupportRefreshToken(true);
    //        tokenServices.setReuseRefreshToken(true);
    //        tokenServices.setClientDetailsService(clientDetails());
    //
    //        return tokenService;
    //    }

}
