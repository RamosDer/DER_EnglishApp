package com.my_company.eapp.jwt.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private final TokenUtil tokenUtil;
    
    @Autowired
    public JWTAuthenticationFilter(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil; // Asigna el objeto TokenUtil pasado como argumento a la variable de instancia tokenUtil
    }

    // Intenta autenticar la solicitud HTTP recibida
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();

        // Intenta leer y mapear el cuerpo de la solicitud a un objeto AuthCredentials
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {
            // En caso de error de lectura, no hace nada
        }

        // Crea un token de autenticación con el nombre de usuario y la contraseña
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword(),
                Collections.emptyList() // Sin roles asociados
        );

        // Autentica el token creado y retorna el resultado
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    // En caso de autenticación exitosa
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal(); // Obtiene los detalles del usuario autenticado

        // Crea un token JWT con el nombre de usuario
        String token = tokenUtil.createToken(userDetails.getUsername());

        // Añade el token JWT al encabezado de la respuesta HTTP
        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush(); // Vacía el buffer de escritura

        
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
