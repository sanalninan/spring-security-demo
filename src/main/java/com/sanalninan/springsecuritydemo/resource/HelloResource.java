package com.sanalninan.springsecuritydemo.resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by 502023168 on 9/11/2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloResource {

    @GetMapping
    public String sayHello(){
        return "Hola";
    }

    @GetMapping
    @RequestMapping("/2")
    public String sayHello2(@AuthenticationPrincipal UserDetails userDetails){
        return "Hola " + userDetails.getUsername();
    }

    @GetMapping
    @RequestMapping("/3")
    public String sayHello3(@AuthenticationPrincipal UserDetails userDetails){
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities
                .forEach(authority->System.out.println(authority));
        return "Hola " + userDetails.getUsername();
    }
}
