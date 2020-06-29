package com.webapi.app;

import java.util.Date;

import com.webapi.app.entities.ApiToken;
import com.webapi.app.entities.Login;
import com.webapi.app.entities.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class AuthController {

    IAuth auth;

    public AuthController(){
        this.auth = new Auth();
    }
    
    @PostMapping("/auth")
    public ResponseEntity<ApiToken> authenticate(@RequestBody User user){

        if(!auth.validate(user)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Login login = new Login("Jesus Caro", "profile.jpg", 28, "admin");

        String KEY = "TOKEN_API";
            long time = System.currentTimeMillis();
            String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, KEY)
                .setSubject("MATCO")
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + 900000))
                .claim("sessionInfo", login)
                .compact();
                ApiToken apiToken = new ApiToken(jwt);
        return new ResponseEntity<>(apiToken, HttpStatus.OK);
    }
}