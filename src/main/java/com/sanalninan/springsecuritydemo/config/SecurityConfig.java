package com.sanalninan.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 502023168 on 9/11/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure  (HttpSecurity security) throws Exception{
        security.authorizeRequests()
                .antMatchers("/hello").hasRole("USER")
                .antMatchers("/hello/3").hasRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
        security.csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sanal").password("test").roles("ADMIN")
                .and()
                .withUser("user").password("user").roles("USER");
    }
}

