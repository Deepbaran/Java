package com.in28minutes.spring.basics.springin5steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] numbers) {
		// Logic for Quick Sort
		return numbers;
	}
}
