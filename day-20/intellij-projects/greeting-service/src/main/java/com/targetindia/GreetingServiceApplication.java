package com.targetindia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GreetingServiceApplication {

	public GreetingServiceApplication() {
		log.info("GreetingServiceApplication constructor called");
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

}
