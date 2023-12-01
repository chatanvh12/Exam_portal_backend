package com.exam.Examserver.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.Examserver.security.JwtAuthenticationEntrypoint;
import com.exam.Examserver.security.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {
	@Autowired
	public JwtAuthenticationEntrypoint point;
	
	@Autowired
	public JwtAuthenticationFilter filter;
	
	@Bean
	public BCryptPasswordEncoder /*PasswordEncoder*/ passwordIncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
	    return auth.getAuthenticationManager();
	}
	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		//jab bhi ye authentication karega tp wo load wale me jayeg
//		auth.userDetailsService(this.userdetailSErvice).passwordEncoder(passwordEncode());
//	}

	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
			http
			.cors(cors->cors.disable())
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(
					auth->auth.requestMatchers("/generate-token","/user/").permitAll()
					.requestMatchers(HttpMethod.OPTIONS).permitAll()
					.anyRequest().authenticated()).exceptionHandling(ex->ex.authenticationEntryPoint(point))
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();

	}
}
