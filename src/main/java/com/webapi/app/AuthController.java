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
import org.springframework.web.bind.annotation.RequestHeader;
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

    @PostMapping("/hello")
    public ResponseEntity<String> HelloSecurity(@RequestHeader String token, @RequestHeader String key, @RequestBody String name){
        if(!verifyToken(token, key)){
            return new ResponseEntity<>("No puedes ver este contenido", HttpStatus.FORBIDDEN);
        }

        String message = "Estas autorizado para ver esto";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
    @PostMapping("/auth")
    public ResponseEntity<ApiToken> authenticate(@RequestBody User user){

        if(!auth.validate(user)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Login login = new Login("Jesus Caro", "profile.jpg", 28, "admin");

        String KEY = "aNdRgUjXn2r5u8x/A?D(G+KbPeShVmYp3s6v9y$B&E)H@McQfTjWnZr4t7w!z%C*F-JaNdRgUkXp2s5v8x/A?D(G+KbPeShVmYq3t6w9z$B&E)H@McQfTjWnZr4u7x!A";
        long time = System.currentTimeMillis();

        String jwt = Jwts.builder()
            .setId("matcoJWT")
            .signWith(SignatureAlgorithm.HS256, KEY)
            .setSubject("jfcarocota")
            .setIssuedAt(new Date(time))
            .setExpiration(new Date(time + 900000))
            .claim("sessionInfo", login)
            .compact();
            //Encryptors.standard(login, "");
            ApiToken apiToken = new ApiToken(jwt);
            
            System.out.println(verifyToken(jwt, KEY));
            System.out.println(verifyToken(jwt, "jhkjdhjkshdk"));

        return new ResponseEntity<>(apiToken, HttpStatus.OK);
    }

    boolean verifyToken(String token, String key){
        try{
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        }catch(io.jsonwebtoken.SignatureException e){
            return false;
        }
        return true;
    }
}