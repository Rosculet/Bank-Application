package com.example.bank_security.config;

import com.example.bank_security.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import java.util.Collection;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class ProjectSecurityConfig {

/*
    @Bean
    public PasswordEncoder passwordEncoder() {return NoOpPasswordEncoder.getInstance();}
*/

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}



    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http.securityContext().requireExplicitSave(false) //security context does not require explicit saving on every change
                .and().sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)) // session will always be created, regardless of user authentication
                .cors().configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowCredentials(true);
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setMaxAge(3600L);
            return config;
        }).and().csrf((csrf)->csrf.csrfTokenRequestHandler(requestHandler) //csrf Customizer
                        .ignoringRequestMatchers("/contact","/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) //Token saved in Coockie and open for read and write
                .addFilterAt(new CsrfCookieFilter(), BasicAuthenticationFilter.class) //adding CsrfCookieFilter in Filter Chain after BasicAuthenticationFilter(standart Filter for Auth HTTP Basic Auth)
                .authorizeHttpRequests(request -> request.requestMatchers("/account", "/loans","balance","/cards")
                .authenticated()
                .requestMatchers("/contact","/notices","/register")
                .permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    /*  @Bean
        public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    } */
}
