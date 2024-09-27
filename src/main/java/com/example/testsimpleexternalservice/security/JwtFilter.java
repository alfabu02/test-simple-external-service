package com.example.testsimpleexternalservice.security;

import com.example.testsimpleexternalservice.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final MyUserDetailsService myUserDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

//        loginWithBearer(request, authorization);
        loginWithBasic(request, authorization);

        filterChain.doFilter(request, response);
    }

    private void loginWithBearer(HttpServletRequest request, String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring("Bearer ".length());
            String email = jwtProvider.getSubjectFromToken(token);
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(email);

            var auth = getAuth(request, userDetails);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }

    private void loginWithBasic(HttpServletRequest request, String authorization) {
        if (authorization != null && authorization.startsWith("Basic")) {
            try {
                String loginAndPasswordInBase64 = authorization.substring("Basic ".length());
                String loginAndPassword = new String(Base64.getDecoder().decode(loginAndPasswordInBase64));
                String[] split = loginAndPassword.split(":");

                String username = split[0];
                String password = split[1];

                // it checks username and password, if they wrong it throws exception (BadCredentialException.class)
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

                // set user to authentication
                // if user does not found, it will throw UsernameNotFoundException
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                var auth = getAuth(request, userDetails);
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (BadCredentialsException | UsernameNotFoundException e) {
                // write your logic here if username or password is wrong
                logger.error(e.getMessage());
            } catch (Exception e) {
                // if base64 is wrong
                // write your logic here
            }
        }
    }

    private static UsernamePasswordAuthenticationToken getAuth(HttpServletRequest request, UserDetails userDetails) {
        var auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        auth.setDetails(new WebAuthenticationDetails(request));
        return auth;
    }
}
