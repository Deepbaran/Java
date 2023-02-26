package com.in28inutes.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;

	@GetMapping("/currency-configuration") // https://localhost:8080/currency-configuration
	public CurrencyServiceConfiguration getAllBooks() {
		return configuration;
	}

}

/*
 * @GetMapping - Get input from the user
 * 
 * @PostMapping - Show data to user
 * 
 * @RequestMapping
 */