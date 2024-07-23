package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/userRegistration", "/userRegistration/**", "/index", "/css/**", "/images/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                );
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/userRegistration/save"))
//                .formLogin(form -> form.disable())
//                .logout(logout -> logout.disable());

        return http.build();
    }
    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/userRegistration", "/userRegistration/**", "/index", "/css/**", "/images/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                );
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/userRegistration/save"))
//                .formLogin(form -> form.disable())
//                .logout(logout -> logout.disable());

        return http.build();
    }
     */

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
