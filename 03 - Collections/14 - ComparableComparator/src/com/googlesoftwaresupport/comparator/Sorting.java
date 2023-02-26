package com.googlesoftwaresupport.comparator;

import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book("A1", "t1", 223));
		books.add(new Book("A2", "t2", 891));
		books.add(new Book("A3", "t3", 34));
		
//		Collections.sort(books, new BookComparator()); // Using the custom comparator, BookComparator
		Collections.sort(books, new BookComparator().reversed()); // Using the custom comparator, BookComparator and using it in reverse order.
		
		System.out.println(books);
	}

}
