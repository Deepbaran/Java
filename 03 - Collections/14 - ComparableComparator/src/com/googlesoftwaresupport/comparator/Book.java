package com.googlesoftwaresupport.comparator;


public class Book {

	private String authorName;
	private String title;
	private int numOfpages;

	public Book() {
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

}
