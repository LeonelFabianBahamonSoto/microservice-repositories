package com.bahamon.reportms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ReportMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportMsApplication.class, args);
	}

}
