package com.jllc;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jllc.Entity.BookEntity;
import com.jllc.repository.BookRepository;

@SpringBootApplication
public class SpringBootCrudOperationApplication {
	private static Logger logger = Logger.getLogger("console");

	public static void main(String[] args) {
		logger.info("----------Main method excuted---------------");
		SpringApplication.run(SpringBootCrudOperationApplication.class);

	}
}
