package com.packtpub.microservices.ch06.gateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class AuthenticationFilter extends OncePerRequestFilter {

    private String signingSecret;

    AuthenticationFilter(String signingSecret) {
        this.signingSecret = signingSecret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> token = Optional.ofNullable(request.getHeader("Authorization"));
        Optional<Authentication> auth = token.filter(t -> t.startsWith("Bearer")).flatMap(this::authentication);
        auth.ifPresent(a -> SecurityContextHolder.getContext().setAuthentication(a));
        filterChain.doFilter(request, response);
    }

    private Optional<Authentication> authentication(String t) {
        System.out.println(signingSecret);
        String actualToken = t.substring("Bearer ".length());
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(signingSecret))
                    .parseClaimsJws(actualToken).getBody();
            Optional<String> userId = Optional.ofNullable(claims.getSubject()).map(Object::toString);
            return userId.map(u -> new UsernamePasswordAuthenticationToken(u, null, new ArrayList<SimpleGrantedAuthority>()));
        } catch (Exception e) {
            return Optional.empty();
        }


    }
}
