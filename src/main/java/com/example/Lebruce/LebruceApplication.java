package com.example.Lebruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Lebruce.repository")
public class LebruceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LebruceApplication.class, args);
	}

}
