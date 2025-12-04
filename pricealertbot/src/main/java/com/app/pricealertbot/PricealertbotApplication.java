package com.app.pricealertbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PricealertbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricealertbotApplication.class, args);
	}

}
