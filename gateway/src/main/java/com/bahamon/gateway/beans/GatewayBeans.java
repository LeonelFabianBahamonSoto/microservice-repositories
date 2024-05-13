package com.bahamon.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans
{
    @Bean
    @Profile( value = "eureka-off" )
    RouteLocator routeLocatorEurekaOff( RouteLocatorBuilder routeLocatorBuilder )
    {
        return routeLocatorBuilder
                .routes()
                .route(
                    route -> route
                        .path("/company/**")
                        .uri("http://localhost:8081") )
                .route(
                    route -> route
                        .path("/report/**")
                        .uri("http://localhost:7070")
                )
            .build();
    };

    @Bean
    @Profile( value = "eureka-on" )
    RouteLocator routeLocatorEurekaOn( RouteLocatorBuilder routeLocatorBuilder )
    {
        return routeLocatorBuilder
                .routes()
                .route(
                    route -> route
                        .path("/company/**")
                        .uri("lb://companies-crud") )
                .route(
                    route -> route
                        .path("/report/**")
                        .uri("lb://report-ms")
                )
            .build();
    };
}