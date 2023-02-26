package com.googlesoftwaresupport.comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		return Integer.compare(b1.getNumOfpages(), b2.getNumOfpages());
		
		/* s1.compareTo(s2)
		 * == 0 -> Equals
		 * > 0 ->  s1 > s2 
		 * < 0 -> s1 < s2
		 */
		// Ineger.compare(n1,, n2);
		
		/* compare()
		 * return >= 0 -> Swap
		 * return < 0 -> Don't Swap
		 */
	}
}
