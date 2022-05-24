package com.diplom.sstufinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SstuFinderApplication {

	private static final Logger logger = LoggerFactory.getLogger(SstuFinderApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SstuFinderApplication.class, args);

		logger.info("all good");

	}

}
