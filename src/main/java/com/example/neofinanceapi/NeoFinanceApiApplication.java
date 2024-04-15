package com.example.neofinanceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NeoFinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeoFinanceApiApplication.class, args);
	}

}
