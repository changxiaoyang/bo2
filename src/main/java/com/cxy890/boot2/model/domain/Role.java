package com.cxy890.boot2.model.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author BD-PC27
 */
public enum Role implements GrantedAuthority {

    USER, ADMIN

    ;

    @Override
    public String getAuthority() {
        return name().toLowerCase();
    }
}
