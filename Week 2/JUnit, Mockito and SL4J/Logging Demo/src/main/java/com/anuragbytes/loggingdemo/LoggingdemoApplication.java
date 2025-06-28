package com.anuragbytes.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingdemoApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingdemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Logging Demo Application...");
		logger.warn("This is a warning message from Spring Boot application");
		logger.error("This is an error message from Spring Boot application");
		
		SpringApplication.run(LoggingdemoApplication.class, args);
		
		logger.info("Logging Demo Application started successfully!");
	}

}
