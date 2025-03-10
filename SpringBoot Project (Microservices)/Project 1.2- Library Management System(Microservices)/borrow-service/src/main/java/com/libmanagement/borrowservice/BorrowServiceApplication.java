package com.libmanagement.borrowservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BorrowServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowServiceApplication.class, args);
	}

	// ✅ RestTemplate Bean for calling other microservices (like USER-SERVICE)
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
