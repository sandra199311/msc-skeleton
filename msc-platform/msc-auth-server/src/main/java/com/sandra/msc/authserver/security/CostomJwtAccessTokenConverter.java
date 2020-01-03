package com.sandra.msc.authserver.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.sandra.msc.authserver.entity.User;

public class CostomJwtAccessTokenConverter extends JwtAccessTokenConverter {

    private static final String TOKEN_USER_ID = "X-UserId";

    @Override
    public OAuth2AccessToken enhance(final OAuth2AccessToken accessToken,
                                     final OAuth2Authentication authentication) {

        final User user = (User) authentication.getUserAuthentication().getPrincipal();
        final Map<String, Object> additionalInformation = new HashMap<>();

        additionalInformation.put(TOKEN_USER_ID, user.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);

        return super.enhance(accessToken, authentication);
    }
}
