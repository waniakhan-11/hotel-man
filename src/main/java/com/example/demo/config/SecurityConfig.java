package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // Disable CSRF for Postman testing
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/rooms/**").authenticated() // Require auth for /rooms
//                .anyRequest().permitAll()
//            )
//            .httpBasic(); // Enable Basic Auth
//
//        return http.build();
//    }
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() // disable for postman post
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("api/admin/**").hasRole("ADMIN")
						.requestMatchers("api/customer/**").hasRole("CUSTOMER")
						.requestMatchers("/api/public/**").permitAll()// don't change here
						.anyRequest().authenticated())
				.httpBasic();
		return http.build();
//		http.csrf().disable() // disable for postman post
//				.authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").hasRole("ADMIN")
//						.anyRequest().authenticated())
//				.httpBasic();
//		return http.build();
	}

	@Deprecated
	@Bean
	public NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Deprecated
	@Bean
	public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
			NoOpPasswordEncoder encoder) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder);
		return authProvider;
	}

	@Deprecated
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, NoOpPasswordEncoder encoder,
			UserDetailsService userDetailsService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.authenticationProvider(authenticationProvider(userDetailsService, encoder)).build();
	}

}
