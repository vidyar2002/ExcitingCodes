package com.cms.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.cms.beans.User;

public class UserRepositoryUserDetails extends UserDto implements UserDetails {
	private static final long serialVersionUID = 1L;

    public UserRepositoryUserDetails(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getUsername() {
        return getEmail();//inherited from user
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;//not for production just to show concept
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;//not for production just to show concept
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//not for production just to show concept
    }

    @Override
    public boolean isEnabled() {
        return true;//not for production just to show concept
    }
}
