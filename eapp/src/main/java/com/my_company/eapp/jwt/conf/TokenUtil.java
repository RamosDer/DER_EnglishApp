package com.my_company.eapp.jwt.conf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    
    private static final Logger logger = LogManager.getLogger(TokenUtil.class);

    //La mejor fomra de gestionar estos valores es a traves de los proterties del proyecto
    @Value("${token.access.secret}")
    private  String accessTokenSecret;

    //Se utiliza el nombre para enviar data adicional en el mismo token
    //Se convierne los segundos a milisegundos
    //El nombre viene del usuario, tambien se pueden añadir mas campos como corrreo electronico
    public String createToken(String username) {
        
        //long expirationTime = accessTokenValiditySeconds * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(accessTokenSecret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    //Metodo para retornar un userPassword authentication token para que Spring Srcurity reconozca y pueda pasar el proceso de autorizacion
    //para un usuario que esta intentado ingresar a un endpoint meidante un token (el token va a estar en formato plano)
    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(accessTokenSecret.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String user = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        } catch (ExpiredJwtException e) {
            logger.info("Error el token ha expirado: " + e.getMessage());
            return null;
        } catch (SignatureException  e) {
            logger.info("Error de firma del token: " + e.getMessage());
    return null; 
}
    }
}
