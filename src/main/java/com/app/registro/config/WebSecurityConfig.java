package com.app.registro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final UserDetailsService userDetailsService;
	
	public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	SecurityFilterChain securityFilter(HttpSecurity http ) throws Exception {
		http
			.authorizeHttpRequests((auth) -> auth
					.requestMatchers("/", "/login", "/registrati", "/css/**", "/js/**").permitAll()
					.requestMatchers("/admin").authenticated()
					.anyRequest().authenticated()
			)
			.formLogin((form) -> form
					.loginPage("/login")
					.loginProcessingUrl("/processa-login")
					.usernameParameter("email")
					.passwordParameter("password")
					.defaultSuccessUrl("/admin", true)
					.failureUrl("/login?error=true")
					.permitAll()
			)
			.logout((logout) -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout=true")
					.permitAll()
			);
		
		http.userDetailsService(userDetailsService);
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	UserDetailsService userDetailsService() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		UserDetails user =
				User.builder()
					.username("user")
					.password(encoder.encode("password"))
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
