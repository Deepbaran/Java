package com.in28minutes.spring.basics.springin5steps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// Telling Spring that BinarySearchImpl is a bean that it needs to manage
//@Component
@Service // It is a service as it is providing a Business Logic.
//@Scope("prototype") //Setting the scope of this bean to "prototype"
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Setting the scope of this bean to "prototype" using ConfigurableBeanFactory
public class BinarySearchImpl {
	
	private Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);
	
	// Telling Spring that it is a dependency
	@Autowired // Autowiring by type <- This is also termed as Setter Injection even if no setter is there.
	private SortAlgorithm sortAlgorithm; // Spring will try to find Components of same type for Autowiring
	// As SortAlgorithm is an interface, so Spring will try to find the implementations of SortAlgorithm for Autowiring.
	
//	@Autowired // Autowiring by name. This hapens only if there is no @Primary
//	private SortAlgorithm bubbleSortAlgorithm; 
	/* Spring will Autowire BubbleSortAlgorithm as both implementations of SortAlgorithm are @Component and if none had @Primary then this Autowiring would happen by name.
	 @Primary has precedence over name of the variable. */
	
//	@Autowired
//	@Qualifier("quick") // SortAlgorithm implementation with @Qualifier("quick") will be Autowired.
//	private SortAlgorithm sortAlgorithm;
	
	//Constructor Injection <- @Autowired of the bean needs need to be there for it to be an injection.
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}
	
	//Setter Injection <- @Autowired of the bean needs need to be there for it to be an injection.
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}


	public int binarySearch(int[] numbers, int numberToSearch) {
		
		//Implement Sorting Logic
		//Bubble Sort Algorithm
		/*
		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		*/
		/*
		 * Here the sorting algorithm is tightly coupled with Bubble Sort Algorithm.
		 * So, if we want to change the sorting algorithm, we will need to change the whole code.
		 * This is what tightly coupled means.
		 */
		
		// To make the sorting algorithm, loosely coupled
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		/*
		 * This is how interfaces make the code loosely coupled
		 * We have now made the Binary Search algorithm, independent of the type of Sorting Algorithm.
		 */
		
		//Search the array
		
		return 3;
	}
	
	@PostConstruct
	public void postConstruct() {
		// This would be executed as soon as the bean is created and initialized using the dependencies.
		LOGGER.info("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		// This would be executed just before the bean is destroyed.
		LOGGER.info("preDestroy");
	}

}
