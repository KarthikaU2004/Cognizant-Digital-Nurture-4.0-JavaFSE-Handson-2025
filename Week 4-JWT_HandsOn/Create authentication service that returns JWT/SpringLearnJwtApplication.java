package com.cognizant.spring_learn_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cognizant")
public class SpringLearnJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnJwtApplication.class, args);
	}
}
