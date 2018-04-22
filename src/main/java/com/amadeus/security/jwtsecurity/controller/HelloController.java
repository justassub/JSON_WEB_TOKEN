package com.amadeus.security.jwtsecurity.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/")
public class HelloController {

    @GetMapping(value = "/vip")
    @PreAuthorize("hasRole('ROLE_VIP')")
    public String vip(){
        return "Hello VIP";
    }
    @GetMapping(value = "/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String user(){
        return "Hello USER";
    }
    @GetMapping(value = "/both")
    @PreAuthorize("hasAnyRole('ROLE_USER,ROLE_VIP')")
    public String both(){
        return "Hello BOTH";
    }







}
