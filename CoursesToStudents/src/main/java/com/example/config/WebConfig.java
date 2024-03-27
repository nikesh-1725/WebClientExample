package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {
	
	@Bean
	public WebClient client() {
		return WebClient.builder().build();
	}

}
