package com.in28inutes.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This is a REST Controller for the Book CLass
@RestController //This annotation registers the class as a component
public class BooksController {

	// Cretirng a REST Service to get a JSON response back
	// Creting a Simple GET REST request and Mapping it to a URI
	@GetMapping("/books") // https://localhost:8080/book
	public List<Book> getAllBooks() {
		// This will be returned whenever the /books uri is accessed
		// A JSON response will be returned. This is a REST Service.
		return Arrays.asList(
				new Book(1l, "Harry Potter", "J. K. Rowling"));
	}
	
}

/*
@GetMapping - Get input from the user
@PostMapping - Show data to user
@RequestMapping
*/