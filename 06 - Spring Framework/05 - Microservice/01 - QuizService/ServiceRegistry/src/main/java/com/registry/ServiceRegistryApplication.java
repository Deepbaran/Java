package com.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}

/*
For load balancing, the services needs to be deployed on different ports.
For deploying the services on different ports, we will need to deploy their Jars on different ports.
To deploy the jars on different ports, we will need to create jars of the services with different port values.
 */
