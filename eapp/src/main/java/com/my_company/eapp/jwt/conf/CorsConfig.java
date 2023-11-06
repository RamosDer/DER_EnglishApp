package com.my_company.eapp.jwt.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    // Método anotado con @Bean para crear un bean de tipo WebMvcConfigurer
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        // Retorna una instancia anónima de WebMvcConfigurer
        return new WebMvcConfigurer() {

            // Sobrescribe el método addCorsMappings para configurar CORS
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                // Añade una ruta de mapeo para "/login" y configura CORS para esa ruta
                registry.addMapping("/login")
                        .allowedOrigins("http://localhost:4200") // Origenes permitidos
                        .allowedMethods("*") // Todos los métodos HTTP son permitidos
                        .exposedHeaders("*"); // Expone todos los encabezados HTTP

                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") 
                        .allowedMethods("*"); 
            }
        };
    }
}
