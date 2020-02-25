package com.sandra.msc.services.provider.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.util.FileCopyUtils;

import com.sandra.msc.common.core.security.CostomJwtAccessTokenConverter;
import com.sandra.msc.common.core.security.StoreTokenServices;

@Configuration
public class TokenConfig {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {

        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public ResourceServerTokenServices tokenServices() {

        return new StoreTokenServices(tokenStore());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {

        final JwtAccessTokenConverter converter = new CostomJwtAccessTokenConverter();
        final Resource resource = new ClassPathResource("public.cert");
        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;

    }
}
