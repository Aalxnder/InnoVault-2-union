package com.innovaultmy.app.JWT.config;
//
//import com.innovaultmy.app.JWT.jwtImp.JwtAuthenticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig
//{
//    private final AuthenticationProvider authProvider;
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//    {
//        return http
//                .csrf(csrf ->
//                        csrf.disable())
//                .authorizeHttpRequests(authRequest ->
//                        authRequest
//                                .requestMatchers("/auth/++").permitAll()
//                                .anyRequest().authenticated())
//                .sessionManagement(sessionmanager ->
//                        sessionmanager
//                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/sesion/Login") // Ruta a tu formulario de inicio de sesión personalizado
//                                .permitAll())
//                .authenticationProvider(authProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//
//    }
//}
