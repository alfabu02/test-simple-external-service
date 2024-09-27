package com.example.testsimpleexternalservice.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.testsimpleexternalservice.document.User;


import java.util.Collection;
import java.util.Collections;


@Getter
@RequiredArgsConstructor
public class MyUserDetails implements UserDetails {
    private final User user;
    private final Collection<? extends GrantedAuthority> authorities = Collections.emptyList();

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
