package com.sandra.msc.common.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * User
 *
 * @author sandra
 * @date 2020年1月2日
 */
public class CostomUserDetails implements UserDetails {

    private static final long serialVersionUID = -3505703865904288395L;

    private Long id;

    private String username;

    private String password;

    public static long getSerialversionuid() {

        return serialVersionUID;
    }

    public Long getId() {

        return id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    @Override
    public String getUsername() {

        return username;
    }

    public void setUsername(final String username) {

        this.username = username;
    }

    @Override
    public String getPassword() {

        return password;
    }

    public void setPassword(final String password) {

        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

}
