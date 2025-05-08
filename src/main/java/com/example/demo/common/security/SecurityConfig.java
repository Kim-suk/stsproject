package com.example.demo.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //설정 용 클래스
@EnableWebSecurity // 웹 보안에 대한 클래스
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())  //csrf : 웹 사이트 공격 
			.authorizeHttpRequests(auth -> auth //authorizeHttpRequests : 권한을 어떻게 줄거지?
					.requestMatchers("/**").permitAll() //requestMatchers : 문자열안에 있는 맞는 정규식이 있으면 어떻게 할거냐
					.anyRequest().authenticated() 										// permitAll : 모든애들 // anyRequest : 권한 허용
			);
		return http.build();
	}
}
