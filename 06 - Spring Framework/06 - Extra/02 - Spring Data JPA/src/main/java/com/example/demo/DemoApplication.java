package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Run some code after application starts
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		Student deep = new Student(
				"Deepbaran",
				"Kar",
				"deep@email.com",
				25
		);
		/*
		SQL passed by Hibernate:
			insert
			into
				student
				(age, email, first_name, last_name, id)
			values
				(?, ?, ?, ?, ?)
		 */
		return args -> {
			studentRepository.save(deep);
		};
	}

}
