package com.googlesoftwaresupport.comparable;

public class Book implements Comparable<Book> {

	private String authorName;
	private String title;
	private int numOfpages;

	public Book() {
		super();
	}

	public Book(String authorName, String title, int numOfpages) {
		this.authorName = authorName;
		this.title = title;
		this.numOfpages = numOfpages;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfpages() {
		return numOfpages;
	}

	public void setNumOfpages(int numOfpages) {
		this.numOfpages = numOfpages;
	}

	@Override
	public String toString() {
		return "Book [authorName=" + authorName + ", title=" + title + ", numOfpages=" + numOfpages + "]";
	}
	
	@Override
	public int compareTo(Book otherBook) {
		return this.getAuthorName().compareTo(otherBook.getAuthorName());
		/* s1.compareTo(s2)
		 * == 0 -> Equals
		 * > 0 ->  s1 > s2 
		 * < 0 -> s1 < s2
		 */
		// Ineger.compare(n1,, n2);
		
		/* compareTo()
		 * return >= 0 -> Swap
		 * return < 0 -> Don't Swap
		 */
	}

}
