package com.my_company.eapp.jwt.conf;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@AllArgsConstructor
public class JWTAuthorizationFilter extends OncePerRequestFilter{ 
    
    private final TokenUtil tokenUtil;
    
    // Define el comportamiento del filtro para cada solicitud
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el token de autorización de la cabecera de la solicitud HTTP
        // Este es el paso cuando el usuario ya tiene un token y hace una solicitud a cualquier endpoint
        String bearerToken = request.getHeader("Authorization");

        // Si el token existe y empieza por "Bearer ", se procesa
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            // Extrae el token quitando el prefijo "Bearer "
            String token = bearerToken.replace("Bearer ", "");
            
            // Usa TokenUtil para obtener un objeto de autenticación a partir del token
            UsernamePasswordAuthenticationToken usernamePAT = tokenUtil.getAuthentication(token);

            // Establece el objeto de autenticación en el contexto de seguridad actual
            SecurityContextHolder.getContext().setAuthentication(usernamePAT);
        }

        // Pasa la solicitud y la respuesta al siguiente filtro en la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
