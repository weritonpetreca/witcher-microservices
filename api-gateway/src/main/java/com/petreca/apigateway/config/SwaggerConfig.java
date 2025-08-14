package com.petreca.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SwaggerConfig {

    @Bean
    public RouterFunction<ServerResponse> swaggerRoutes() {
        return route(GET("/swagger-ui.html"), 
            request -> ServerResponse.temporaryRedirect(java.net.URI.create("/webjars/swagger-ui/index.html")).build());
    }
}