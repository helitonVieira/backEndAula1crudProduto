package com.vsystem.evento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vsystem.evento.services.EmailService;
import com.vsystem.evento.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	
	@Bean
	public EmailService emailService() { //implementação para teste de email return no console
		return new MockEmailService();
	}
	
	
}
