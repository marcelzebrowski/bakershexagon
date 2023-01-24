package com.sugar.bakers.company.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sugar.bakers.company.infrastructure.database") // it is very important to define the scanBasePackage!
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
