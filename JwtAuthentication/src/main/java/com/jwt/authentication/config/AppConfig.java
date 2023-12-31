package com.jwt.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    //Im memory authentication
//    @Bean
//    public UserDetailsService userDetailsService(){
//      UserDetails user = User.builder().username("Ritika").password(passwordEncoder().encode("Ritzz@123")).roles("ADMIN").build();
//      UserDetails user1 = User.builder().username("Rahul").password(passwordEncoder().encode("Rahul@123")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, user1);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
