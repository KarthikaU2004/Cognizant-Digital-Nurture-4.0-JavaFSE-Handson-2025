package com.cognizant.springlearn1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearn1Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearn1Application.class, args);
		displayCountry();
		System.out.println(" Application started successfully!");
	}

	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}
}
