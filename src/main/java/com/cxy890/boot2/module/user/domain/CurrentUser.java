package com.cxy890.boot2.module.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author BD-PC27
 */
@Data
@Entity
@Table(name = "e_users")
public class CurrentUser implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean isEnabled;

    private String authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        if (authorities != null) {
            String[] split = authorities.split(";");
            for (String r : split) {
                roles.add(Role.valueOf(r.toUpperCase()));
            }
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
