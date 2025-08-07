package com.petreca.bestiaryandarmory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class BestiaryAndArmoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestiaryAndArmoryServiceApplication.class, args);
	}

}
