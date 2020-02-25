package com.sandra.msc.common.core.security;

import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * 
 * SecurityUtils
 *
 * @author sandra
 * @date 2020年1月3日
 */
public class SecurityUtils {

    public static ResourceServerTokenServices buildRedisStoreTokenServices() {

        //        final TokenStore tokenStore = new RedisTokenStore();
        //        final StoreTokenServices tokenServices = new StoreTokenServices(tokenStore);

        return null;
    }
}
