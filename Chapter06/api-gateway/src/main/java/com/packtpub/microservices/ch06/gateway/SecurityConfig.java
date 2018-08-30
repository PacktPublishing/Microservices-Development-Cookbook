package com.packtpub.microservices.ch06.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.secret}")
    private String signingSecret;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
            .csrf().disable()
            .logout().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .anonymous()
            .and()
                .exceptionHandling().authenticationEntryPoint(
                    (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
            .addFilterAfter(new AuthenticationFilter(signingSecret),
                    UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/messages/**").authenticated()
            .antMatchers("/users/**").authenticated();
    }
}
