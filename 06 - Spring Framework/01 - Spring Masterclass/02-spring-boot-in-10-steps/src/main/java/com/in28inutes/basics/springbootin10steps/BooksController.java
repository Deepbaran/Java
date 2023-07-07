package com.in28inutes.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Basically Controllers are the API Endpoints
// This is a REST Controller for the Book CLass
@RestController // This annotation registers the class as a component
public class BooksController {

	// Creating a REST Service to get a JSON response back
	// Creating a Simple GET REST request and Mapping it to a URI
	@GetMapping("/books") // https://localhost:8080/books
	public List<Book> getAllBooks() {
		// This will be returned whenever the /books uri is accessed
		// A JSON response will be returned. This is a REST Service. This is called a JSON conversion. From List of Courses to a JSON List
		return Arrays.asList(new Book(1l, "Harry Potter", "J. K. Rowling"),
				new Book(2l, "Twilight", "Stephenie Meyer"));
	}

}

/*
 * @GetMapping - Get input from the user
 * 
 * @PostMapping - Show data to user
 * 
 * @RequestMapping
 */