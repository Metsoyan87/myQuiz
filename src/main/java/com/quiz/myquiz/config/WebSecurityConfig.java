package com.quiz.myquiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class WebSecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/customLogin").permitAll();
                    auth.requestMatchers("/admin").hasRole("TEACHER");
                    auth.anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/customLoginPage")
                        .defaultSuccessUrl("/customSuccessLogin")
                        .loginProcessingUrl("/login")

                )
                .logout(logout -> {
                    logout.logoutUrl("/");
                })
                .build();

//        httpSecurity.authorizeHttpRequests(authz -> authz
//                        .requestMatchers(HttpMethod.GET, "/").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/loginPage").permitAll()
//                        .requestMatchers("/admin").hasAuthority("TEACHER")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());


    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }


}
