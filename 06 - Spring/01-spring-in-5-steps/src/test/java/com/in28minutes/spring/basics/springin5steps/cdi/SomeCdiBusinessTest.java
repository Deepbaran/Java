package com.in28minutes.spring.basics.springin5steps.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsBasicApplication;
import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsCdiApplication;

//Load the context
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = SpringIn5StepsCdiApplication.class)
@SpringBootTest //Loads the whole context of the application
class SomeCdiBusinessTest {

	// Get this bean from the context
	@Autowired
	SomeCdiBusiness business;

	@Test
	public void testBasicScenario() {
		
		// call method on binarySearch
		int actualResult = business.findGreatest();

		// check if the value is correct
		assertEquals(100, actualResult);

	}

}
