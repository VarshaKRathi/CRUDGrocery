package com.dev2qa.example.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.dev2qa.example.mvc.model")
public class SpringBootGroceryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGroceryApplication.class, args);
	}

}
