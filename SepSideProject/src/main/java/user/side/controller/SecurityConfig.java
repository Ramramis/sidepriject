package user.side.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .anyRequest().permitAll()  // 모든 요청에 대해 인증 없이 허용
	            .and()
	            .csrf().disable()  // CSRF 보호 비활성화
	            .formLogin().disable();  // 기본 로그인 폼 비활성화
	        return http.build();
	    }

}
