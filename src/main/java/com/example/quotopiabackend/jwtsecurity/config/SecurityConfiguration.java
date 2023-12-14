package com.example.quotopiabackend.jwtsecurity.config;

import com.example.quotopiabackend.jwtsecurity.JwtAuthenticationEntryPoint;
import com.example.quotopiabackend.jwtsecurity.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@CrossOrigin
@Configuration
@AllArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {



    private static PasswordEncoder passwordEncoder;
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    private JwtFilter filter;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        if (passwordEncoder == null) {
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests(requests -> requests
                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()  // Allow all requests to /login
                        .requestMatchers(new AntPathRequestMatcher("/signup")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/api/author**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/author/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/author/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/genre**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/genre/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/genre")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/quote**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/quote/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/quote")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/subgenre**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/subgenre/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/subgenre")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/quote/byGenre")).permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("addCorsMappings called");
        registry.addMapping("/**")  // /** means match any string recursively
                .allowedOriginPatterns("http://localhost:*/", "http://127.0.0.1:*/") //Multiple strings allowed. Wildcard * matches all port numbers.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // decide which methods to allow
                //   preflight checks to return successful
                .allowedHeaders("*")
                .allowCredentials(true);
    }


}
