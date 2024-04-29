package com.mrsurenk.contactmanager.configurations;

import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {
    private final UserAccountRepo userAccountRepo;

    public ApplicationConfiguration(UserAccountRepo userAccountRepo){
        this.userAccountRepo = userAccountRepo;
    }

    @Bean
    UserDetailsService userDetailsService(){
        return username -> userAccountRepo.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }




}
