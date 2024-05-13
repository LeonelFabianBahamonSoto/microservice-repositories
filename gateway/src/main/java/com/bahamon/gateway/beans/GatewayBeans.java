package com.bahamon.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeans
{
    // @Profile( value = "eureka-off" )
    @Bean
    RouteLocator routeLocator( RouteLocatorBuilder routeLocatorBuilder )
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
}

// .route("ws1", r -> r.path("/data1").uri("lb:ws://market.data/api"))