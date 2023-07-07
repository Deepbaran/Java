package com.in28minutes.spring.basics.springin5steps.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsBasicApplication;
import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsCdiApplication;

//As we are not using any Spring Context, so we can use the Runner for Mockito. If we needed the Spring Context then we would have required to use @Rule for the Mockito
@RunWith(MockitoJUnitRunner.class)
class SomeCdiBusinessMockitoTest {
	
	@Mock
	SomeCdiDao daoMock;
	
	@InjectMocks
	SomeCdiBusiness business;

	@Test
	public void testBasicScenario() {
		
		// when doMock.getData() method is called return int[]{2,4}
		Mockito.when(daoMock.getData()).thenReturn(new int[] {2,4});
		
		// call method on binarySearch
		int actualResult = business.findGreatest();

		// check if the value is correct
		assertEquals(4, actualResult);

	}

}
