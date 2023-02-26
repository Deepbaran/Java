package com.in28minutes.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.spring.basics.springin5steps.xml.XmlPersonDAO;

// We do not need these as we are using XML Configuration
//@SpringBootApplication
//@Configuration
//@ComponentScan
public class SpringIn5StepsXmlContextApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXmlContextApplication.class);

	public static void main(String[] args) {

		// Using XML application context
		// All beans defined inside applicationContext.xml is loaded and if we want to load more, then we need to use context:component-scan in the xml
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		// Beans loaded in the Application Context
		LOGGER.info("Beans Loaded: {}", (Object)applicationContext.getBeanDefinitionNames());
		
		XmlPersonDAO personDao = applicationContext.getBean(XmlPersonDAO.class);
		LOGGER.info("{} {}", personDao, personDao.getXmlJdbcConnection());
		
		applicationContext.close();
	}

}
