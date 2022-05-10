package com.in28minutes.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.spring.basics.springin5steps.xml.XmlPersonDAO;

@SpringBootApplication
public class SpringIn5StepsXmlContextApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXmlContextApplication.class);

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		// Beans loaded in the Application Context
		LOGGER.info("Beans Loaded: {}", (Object)applicationContext.getBeanDefinitionNames());
		
		XmlPersonDAO personDao = applicationContext.getBean(XmlPersonDAO.class);
		LOGGER.info("{} {}", personDao, personDao.getXmlJdbcConnection());
		
		applicationContext.close();
	}

}
