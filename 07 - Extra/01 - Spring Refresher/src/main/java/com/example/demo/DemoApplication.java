package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// API Layer <-> Service Layer <-> Data Access Layer <-> DB

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.example.demo.DemoApplication.class, args);
	}

}

//@SpringBootApplication
//@RestController //Makes this bean a Rest Controller
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//	@GetMapping
//	public List<Student> Hello() {
//		return List.of(
//				new Student(
//						1L,
//						"Deep",
//						"deep@email.com",
//						LocalDate.of(1997, Month.JANUARY, 5),
//						21
//				)
//		);
//	}
//
////	@GetMapping //Send a request back - Basically an endpoint
////	public List<String> Hello() {
//////		return "Hello World"; // Send back a String
////		return List.of("Hello", "World"); //Sends back a JSON
////	}
//
//}
