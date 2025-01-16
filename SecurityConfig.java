package com.example.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.todolist.repository.UserRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity // Habilita a segurança baseada em anotações (ex.: @PreAuthorize)
public class SecurityConfig {

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/api/users/**")).permitAll() // Permite acesso a rotas públicas
                .anyRequest().authenticated() // Requer autenticação para qualquer outra rota
            )
            .httpBasic(withDefaults()); // Habilita autenticação básica (opcional)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Para codificar senhas
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    public SecurityConfig(UserRepository userRepository) {
    }
}