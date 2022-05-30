package com.vsystem.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VSystemEventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VSystemEventoApplication.class, args);
		
		System.out.println("Sucesso na execussão vsystem eventos!");
	}

}
