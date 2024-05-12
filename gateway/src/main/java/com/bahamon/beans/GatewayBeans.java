package com.bahamon.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans {

    @Bean
    @Profile( value = "eureka-off" )
    public RouteLocator routeLocator( RouteLocatorBuilder builder )
    {
        return builder.routes()
            .route(route -> route
                .path("/companies-crud/company/*")
                .uri("http://localhost:8081")
            )
            .route(
                route -> route
                    .path("/report/*")
                    .uri("http://localhost:7070")
            )
                .build();
    };

}
