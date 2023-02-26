package com.globalsoftwaresupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {	
	
	public static void main(String[] args) {
	
		List<Integer> nums = new ArrayList<>();
		
		nums.add(10);
		nums.add(20);
		nums.add(30);
			
		// Using unmodifiable is a good way to make sure that the data structure remains unchanged when we are working with getters and setters
		nums = Collections.unmodifiableList(nums); 
		
		modify(nums);
		
		System.out.println(nums);
	}
	
	public static void modify(List<Integer> list) {
		list.add(0); // throws exception as list is set as unmodifiable (Contents cannot be updated)
	}
}