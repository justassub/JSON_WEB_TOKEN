package com.amadeus.security.jwtsecurity.security;

import com.amadeus.security.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Calendar;

@Component
public class JwtGenerator {


    /**
     * Token generator . Generates token that expires after 30 min.
     * @param jwtUser
     * @return
     * @throws ParseException
     */
    public String generate(JwtUser jwtUser) throws ParseException {
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());
        //setExpirationDate :
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, 5);
        claims.setExpiration(now.getTime());
        System.out.println(claims.getExpiration());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "amadeus")
                .compact();
    }

}
