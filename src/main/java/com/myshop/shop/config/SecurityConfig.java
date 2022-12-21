//package com.myshop.shop.config;
//
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//@Log4j2
//
//public class SecurityConfig {
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService() {
////        UserDetails user = User.builder()
////                .userId("user1")
////                .userPw(passwordEncoder().encode("1111"))
////                .build();
////
////        log.info("userDetailsService............................");
////        log.info(user);
////
////        return new InMemoryUserDetailsManager(user);
////    }
//
//}
