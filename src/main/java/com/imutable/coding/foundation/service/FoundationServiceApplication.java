package com.imutable.coding.foundation.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class FoundationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoundationServiceApplication.class, args);
	}

}
