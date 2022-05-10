package com.in28minutes.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.properties.SomeExternalService;

@SpringBootApplication
//app.properties
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsPropertiesApplication.class); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
		System.out.println(service.returnServiceURL());
	}

}
