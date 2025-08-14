package com.petreca.bestiaryandarmory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Auth Service API", version = "1.0", description = "API for user authentication and management"))
@SecurityRequirement(name = "Bearer Authentication") // Tells Swagger to apply this security scheme to all endpoints
@SecurityScheme( // Defines HOW the security is applied
		name = "Bearer Authentication",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
public class BestiaryAndArmoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestiaryAndArmoryServiceApplication.class, args);
	}

}
