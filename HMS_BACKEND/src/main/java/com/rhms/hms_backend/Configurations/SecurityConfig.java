package com.rhms.hms_backend.Configurations;


import com.rhms.hms_backend.Models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig  {

    @Autowired
    private final JWTAuthFilter jwtAuthFilter;

    @Autowired
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

       http.cors();   // Disable Cross-Site Request Forgery (CSRF)
        http.csrf().disable();  // Set the session creation policy to stateless
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/user/complain/**").permitAll()

                .requestMatchers("/api/hostal/**").permitAll()
                .requestMatchers("/api/room/**") .permitAll()

                .requestMatchers("/api/user/admin").hasRole(Role.ADMIN.name())
                .requestMatchers("/api/user/student").hasRole(Role.STUDENT.name())
                .requestMatchers("/api/user/warden").hasRole(Role.WARDEN.name())
                .requestMatchers("/api/user/dean").hasRole(Role.DEAN.name())
                .requestMatchers("/api/user/subwarden").hasRole(Role.SUBWARDEN.name())

                .requestMatchers("api/admin/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
