package com.in28minutes.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;

@Configuration
@ComponentScan
//@SpringBootApplication
public class SpringIn5StepsBasicApplication {
	
	//Making Spring wire the classes and dependencies together
	//What are the beans? -> @Component
	//What are the dependencies of a bean? -> @Autowired
	//Where to search for beans? => No need as all beans are in the same package

	public static void main(String[] args) {

		/* Now, the Sortalgorithm has become a dependency of the BinarySearchImpl.
		 * As we need to provide the type of SortAlgorithm for the Binary Search to function.
		 * So BinarySearch depends on sortAlgorithm. And SortAlgorithm is a dependency.
		 * We have made the SortAlgorithm as a separate dependency and we are passing it to the BinarySearchImpl
		 */
		/*
		 * We are creating a object of the BinarySearchImpl and we are creating an object of the sorting algortihm
		 * and we are wiring them together and then we are invoking the BinarySearchImpl.
		 * We made the BinarySearchImpl loosely coupled by passing the sort algorithm to use as one of the constructor arguments.
		 */
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm()); // new QuickSortAlgorithm() is a bean
//		
//		int result = binarySearch.binarySearch(new int[] {12, 4, 6}, 3);
//		System.out.println(result);
		
		// The Beans, BinarySearchImpl and QuickSortAlgorithm will be managed by Application Context
		//ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsBasicApplication.class, args); // It returns the Application Context for SpringIn5StepsCdiApplication.class
		
		
		// This context is used with Spring Core and if we are using Spring Boot, we need to use the above one.
		// This one needs to be closed explicitly unlike the above one.
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
		
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
		
//		System.out.println(binarySearch); //BinarySearchImpl@4fbb001b
//		System.out.println(binarySearch1); //BinarySearchImpl@4fbb001b
		/* Both BinarySearchImpl objects are same.
		 So, we are getting the same object (bean) from the application context.
		 No matter how many times we try to get the same bean from the application context, we will get the same bean back..
		 Because, by default the Bean Scope is set to "singleton".
		 These type of Beans are called "singleton beans".*/
		
		/*
		 * To get a new bean/instance/object everytime we request a bean from the Application Context,
		 * we need to set the Bean Scope to "prototype". That means, we will need a "prototype bean".
		 * In case of prototype beans, we will get two different instances of the same bean if we called it twice from the Application Context.
		 */
		//BinarySearchImpl is set as prototype bean
		System.out.println(binarySearch); //BinarySearchImpl@676f0a60
		System.out.println(binarySearch1); //BinarySearchImpl@5d10455d
		
		int result = binarySearch.binarySearch(new int[] {12, 4, 6}, 3);
		System.out.println(result);
		
		applicationContext.close();
		
		/*Steps after adding Spring annotations:
		 * 1. Search for the beans
		 * 2. Found beans/components (BinarySearchImpl and SortAlgortihm)
		 * 3. Create instance of bean 'binarySearchAlgorithm'
		 * 4. Create instance of bean 'bubbleSortAlgorithm'
		 * 5. Finished creating instance of bean 'bubbleSortAlgorithm'
		 * 6. Constructor Injection - Autowiring BY TYPE from bean name 'binarySearchAlgorithm' via constructor to bean named 'bubbleSortAlgorithm'
		 *    Setter Injection - Autowiring BY TYPE from bean name 'binarySearchAlgorithm' to bean named 'bubbleSortAlgorithm'
		 *    No Setter or Constructor - Autowiring BY TYPE from bean name 'binarySearchAlgorithm' to bean named 'bubbleSortAlgorithm'
		 * 7. Finished creating instance of bean 'binarySearchAlgorithm'
		 */
	
	}

}
