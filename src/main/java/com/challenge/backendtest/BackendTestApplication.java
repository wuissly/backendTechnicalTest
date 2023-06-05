package com.challenge.backendtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestApplication.class, args);
	}

}
