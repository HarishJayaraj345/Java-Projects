package com.library.management;

public class Book {
	
	private int BookID;
	private String BookTitle;
	private boolean AvailableStatus;
	
	public Book(int bookID, String bookTitle) {
		BookID = bookID;
		BookTitle = bookTitle;
		AvailableStatus = true;
	}

	public int getBookID() {
		return BookID;
	}

	public String getBookTitle() {
		return BookTitle;
	}

	public boolean isAvailableStatus() {
		return AvailableStatus;
	}
	
	public String BookStatus() {
		if(AvailableStatus) {
			return "Available";
		}
		return "Not Available";
	}

	public void markIssued() {
		if(AvailableStatus) {
			AvailableStatus =false;
		}
		else {
			System.out.println("Book Already issued...");
		}
	}
	
	public void markReturn() {
		if(!AvailableStatus) {
			AvailableStatus = true;
		}
		else {
			System.out.println("Book has not Issued yet...");
		}
	}
	
	
	
	

}
