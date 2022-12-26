package com.myshop.shop.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@Log4j2

public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user1")
//                .password(passwordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//
//        log.info("userDetailsService............................");
//        log.info(user);
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> {
            auth.antMatchers("/cs/main").permitAll();
            auth.antMatchers("/cs/list").permitAll();
            auth.antMatchers("/cs/read").permitAll();
            auth.antMatchers("/cs/register").hasRole("USER");
            auth.antMatchers("/cs/modify").hasRole("USER");
            auth.antMatchers("/faq/list").permitAll();
            auth.antMatchers("/faq/read").permitAll();
            auth.antMatchers("/faq/modify").hasRole("MANAGER");
            auth.antMatchers("/faq/register").hasRole("MANAGER");
        });

        http.formLogin();
        http.csrf().disable();
        http.logout();

        return http.build();
    }


}
