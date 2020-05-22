package com.manycode.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mark01Application {

	private static final Logger LOGGER=LoggerFactory.getLogger(Mark01Application.class);
	
	public static void main(String[] args) {
		LOGGER.info(">>Inicia programa Mark....");
		SpringApplication.run(Mark01Application.class, args);
	}

}
