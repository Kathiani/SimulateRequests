package com.example.controller.controlrequests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StartupSimulateRequests {

	public static void main(String[] args) {
		SpringApplication.run(StartupSimulateRequests.class, args);
	}

}
