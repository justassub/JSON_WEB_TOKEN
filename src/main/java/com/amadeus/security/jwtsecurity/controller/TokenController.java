package com.amadeus.security.jwtsecurity.controller;

import com.amadeus.security.jwtsecurity.Repository.UserRepository;
import com.amadeus.security.jwtsecurity.model.JwtUser;
import com.amadeus.security.jwtsecurity.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    UserRepository userRepository;

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) throws ParseException {
        JwtUser findUser ;
        try{
            findUser=userRepository.findJwtUserByUserName(jwtUser.getUserName()).get();
        }catch (NoSuchElementException e){
            return "User doesnt exist";
        }

        if(jwtUser.getPassword().equals(findUser.getPassword())){
            return jwtGenerator.generate(findUser);
        }else {
            return "Bad  pss";
        }

    }
    @GetMapping("/vip")
    public String registerVIP(){
        JwtUser jwtUser = new JwtUser();
        jwtUser.setRole("ROLE_VIP");
        jwtUser.setUserName("vip");
        jwtUser.setPassword("vip");
        userRepository.save(jwtUser);
        return "Saved Vip";
    }
    @GetMapping("/simple")
    public String registerSimple(){
        JwtUser jwtUser = new JwtUser();
        jwtUser.setRole("ROLE_USER");
        jwtUser.setUserName("user");
        jwtUser.setPassword("user");
        userRepository.save(jwtUser);
        return "Saved USer";
    }

}
