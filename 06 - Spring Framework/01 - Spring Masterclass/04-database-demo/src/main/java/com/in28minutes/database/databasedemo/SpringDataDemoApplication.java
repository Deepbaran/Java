package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication //Commenting it so that this code is not fired. Uncomment it when needed
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository repository; //It has all the redundant methods pre-defined for the specified Entity.
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", repository.findAll());
//		logger.info("User id 10001 -> {}", repository.findById(10001));
//		logger.info("Inserting 10004 -> {}", repository.save(new Person("Deep","Bangalore",new Date()))); //save -> For insert or update. Similar to merge
//		logger.info("Update 10003 -> {}", repository.save(new Person(10003,"Pieter","Utrecht", new Date())));
//		repository.deleteById(10002);
	}

}
