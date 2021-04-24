package com.example.CalculatorSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class CalculatorSpringBootApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CalculatorSpringBootApplication.class, args);
	}

}
