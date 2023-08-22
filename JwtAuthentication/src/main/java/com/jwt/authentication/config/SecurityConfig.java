package com.jwt.authentication.config;

import com.jwt.authentication.security.JwtAuthenticationEntryPoint;
import com.jwt.authentication.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

@Configuration
@EnableWebMvc
public class SecurityConfig {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Allow all paths, you can restrict it as needed
//                .allowedOrigins("*")     // Allow requests from any origin, you can specify specific origins
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
//                .allowedHeaders("Authorization", "Content-Type");    // Allow all headers, you can specify specific headers
//    }
    @Autowired
    private JwtAuthenticationEntryPoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //configuration

        http.csrf(csrf->csrf.disable())
                .cors(cors-> cors.disable())
                .authorizeHttpRequests(auth-> auth.requestMatchers("/home/**").authenticated() .requestMatchers("/auth/login").permitAll().requestMatchers("/auth/signup-user").permitAll().anyRequest().authenticated()).exceptionHandling(ex->ex.authenticationEntryPoint(point))
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
