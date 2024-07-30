package com.logistica.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LogisticaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaApiApplication.class, args);
	}

}
