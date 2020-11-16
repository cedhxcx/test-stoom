package com.stoom.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {
	
	private static Logger logger = LoggerFactory.getLogger(ChallengeApplication.class);
	
	public static void main(String[] args) {
		logger.info("Iniciando api de cadastro de endereços");
		SpringApplication.run(ChallengeApplication.class, args);
		logger.info("API de cadastro de endereços iniciada e pronta para receber requisições");
	}

}
