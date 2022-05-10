package com.in28minutes.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.in28minutes.spring.basics.componentscan.ComponentDAO;

@SpringBootApplication
@ComponentScan("com.in28minutes.spring.basics.componentscan") //This will make the Spring Boot Application to Scan the specific package.
public class SpringIn5StepsComponentScanApplication {
	
	/*
	 * When  NoSuchBeanDefinitionException exception is thrown, first check if there is a @Component at the bean.
	 * 
	 * ComponentDAO is not in the same or sub package as the @SpringBootApplication annotated main class.
	 * So, the Spring Application can not scan for these components.
	 * 
	 */
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsComponentScanApplication.class, args); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
		
		LOGGER.info("{}", componentDAO);
		
	}

}
