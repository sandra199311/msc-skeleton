package com.sandra.msc.common.core.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 
 * get OAuth2Authentication from tokenStore directly
 *
 * @author sandra
 * @date 2020年1月3日
 */
public class StoreTokenServices implements ResourceServerTokenServices {

    private final TokenStore tokenStore;

    public StoreTokenServices(final TokenStore tokenStore) {

        this.tokenStore = tokenStore;
    }

    @Override
    public OAuth2Authentication loadAuthentication(final String accessToken)
            throws AuthenticationException, InvalidTokenException {

        return tokenStore.readAuthentication(accessToken);
    }

    @Override
    public OAuth2AccessToken readAccessToken(final String accessToken) {

        return tokenStore.readAccessToken(accessToken);
    }

}
