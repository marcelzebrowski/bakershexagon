package com.sugar.bakers.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.sugar.bakers.company.secondary") // it is very important to define the scanBasePackage!
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
