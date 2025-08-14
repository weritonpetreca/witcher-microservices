package com.petreca.witchercontracts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Witcher Contracts API", version = "1.0", description = "API for managing witcher contracts"))
public class WitcherContractsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WitcherContractsServiceApplication.class, args);
	}

}
