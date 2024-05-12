package com.bahamon.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeans {

    @Bean
    public RouteLocator routeLocator( RouteLocatorBuilder builder )
    {
        RouteLocator gatewayBuilder = builder
            .routes()
            .route(
                route -> route
                    .path("/companies/company/*")
                    .uri("http://localhost:8081")
            )
            .route(
            route -> route
                .path("/report/*")
                .uri("http://localhost:7070")
        )
            .build();

        return gatewayBuilder;
    };

}