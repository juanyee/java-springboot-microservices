package com.juanyee.microservices.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;

//import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
//        serverHttpSecurity.authorizeExchange(exchange -> exchange.anyExchange().authenticated())
////                .oauth2Login(withDefaults()); // authenticating on the login form
//                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt); // authenticating in an api request
//        serverHttpSecurity.csrf().disable();
//        return serverHttpSecurity.build();
//    }
}
