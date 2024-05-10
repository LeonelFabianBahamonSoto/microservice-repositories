package com.bahamon.reportms.beans;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadBalancerConfiguration {

    @Bean
    ServiceInstanceListSupplier serviceInstanceListSupplier( ConfigurableApplicationContext context ) {
        log.info("Configurando el Load Balancer");
        return ServiceInstanceListSupplier
            .builder()
            .withBlockingDiscoveryClient()
            .build( context );
            // .withSameInstancePreference() //Quito withSameInstancePreference porque eso solo hace el request a una sola instancia. Para usar el balanceo de carga con multiples instancias eso no nos sirve.
    }

}
