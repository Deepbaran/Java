package com.in28minutes.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;

@SpringBootApplication
public class SpringIn5StepsScopeApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsScopeApplication.class, args); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", personDAO1); //PersonDAO@1f14f20c
		LOGGER.info("{}", personDAO1.getJdbcConnection()); //JdbcConnection@5339bbad
		LOGGER.info("{}", personDAO1.getJdbcConnection()); //JdbcConnection@3935e9a8
		
		LOGGER.info("{}", personDAO2); //PersonDAO@1f14f20c
		LOGGER.info("{}", personDAO2.getJdbcConnection()); //JdbcConnection@288a4658
	}

}
