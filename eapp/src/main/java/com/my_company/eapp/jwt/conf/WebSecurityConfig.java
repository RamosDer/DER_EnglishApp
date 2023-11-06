package com.my_company.eapp.jwt.conf;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;
    private final TokenUtil tokenUtil;  
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
        JWTAuthenticationFilter jWTAuthenticationFilter = new JWTAuthenticationFilter(tokenUtil);
        jWTAuthenticationFilter.setAuthenticationManager(authManager);
        jWTAuthenticationFilter.setFilterProcessesUrl("/login");
        
        return http
                .cors()
                .and()
                .csrf().disable()// Deshabilitar Cross-site request forgery o falsificación de petición en sitios cruzados
                .authorizeHttpRequests()
                .antMatchers("/usuarios/createUsuario")
                .permitAll()
                .anyRequest()//Cualquier solicitud que ingrese a la api tiene que estar autenticada
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Politica de creacion de sesiones(Sin estado)
                .and()
                .addFilter(jWTAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)//se debe establecer el orden en que se va a ejecutar este filtro
                .build();//Se construye el SecurityFilterChain
                
    }
     
    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)//Toma efecto el usuario creado
                .passwordEncoder(passwordEncoder())//Se establecel el passwordEncoder
                .and()
                .build();//Se construye AuthenticationManager
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
