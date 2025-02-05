package com.ronqueroc.pos_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class PosSystemApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PosSystemApplication.class, args);
	}

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
//		corsConfiguration.addAllowedMethod(HttpMethod.PUT);
//		corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
//		corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
//		corsConfiguration.addExposedHeader(HttpHeaders.CONTENT_DISPOSITION);
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfiguration);
//		return source;
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:5173")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("*")
				.allowCredentials(true); // Important for credentials (cookies, auth) - if true, origins MUST be specific, not "*"
		//.exposedHeaders("X-Custom-Header"); // Expose custom headers
	}
}
