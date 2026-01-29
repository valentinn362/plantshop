package com.plantshop.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilitamos CSRF para poder usar Fetch/JS con POST, PUT, PATCH y DELETE
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // Permitimos explícitamente el acceso a los archivos estáticos
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        // Permitimos la raíz y la API para pruebas
                        .requestMatchers("/", "/api/**").permitAll()
                        // Cualquier otra ruta también permitida por ahora
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}