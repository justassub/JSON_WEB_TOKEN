package com.techprimers.security.jwtsecurity.controller;


import com.techprimers.security.jwtsecurity.Repository.UserRepository;
import com.techprimers.security.jwtsecurity.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
