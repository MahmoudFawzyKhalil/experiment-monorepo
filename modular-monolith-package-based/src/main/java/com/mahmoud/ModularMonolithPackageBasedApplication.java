package com.mahmoud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ModularMonolithPackageBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModularMonolithPackageBasedApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

		};
	}

}
