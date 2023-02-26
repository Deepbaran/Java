package com.in28minutes.spring.basics.springin5steps.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
