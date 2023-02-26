package com.in28minutes.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.springin5steps.cdi.SomeCdiBusiness;

//@SpringBootApplication
@Configuration
@ComponentScan
public class SpringIn5StepsCdiApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsBasicApplication.class);
	
	public static void main(String[] args) {
	
//		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsCdiApplication.class); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		// It returns the Application Context for SpringIn5StepsCdiApplication.class
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsCdiApplication.class); 
//		
//		SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);
//		
//		LOGGER.info("{} dao-{}", someCdiBusiness, someCdiBusiness.getSomeCdiDao());
//		
//		applicationContext.close();
		
		// Java 7 feature: Auto closable
		try(AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsCdiApplication.class)) {
		
			SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);
			
			LOGGER.info("{} dao-{}", someCdiBusiness, someCdiBusiness.getSomeCdiDao());
		} catch(Exception e) {
			LOGGER.error("ERROR: {}", e.getMessage());
		}
	}

}
