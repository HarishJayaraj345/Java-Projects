package com.library.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
	
	private List<Book> books;
	private List<Member> member;
	private List<Transaction> transaction;
	
	Library(){
		books = new ArrayList<>();
		member = new ArrayList<>();
		transaction = new ArrayList<>();
	}
	
	//Book Operation 
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book Added "+book.getBookTitle());
	}
	
	public void removeBook(int bookid) {
		
		Iterator<Book> i=	books.iterator();
		
		while(i.hasNext()) {
			Book b = i.next();
			if(b.getBookID()==bookid) {
				i.remove();
				System.out.println("Book Removed "+b.getBookTitle());
				return;
			}
		}
		System.out.println("Invalid id or book not available !");
	}
	
	// member operation
	
	public void addmember(Member m) {
		member.add(m);
		System.out.println("Member Added "+m.getMemberName());
	}
	
	//search operation
	
	Book findBookbyId(int bookId) {
		for(Book B :books) {
			if(B.getBookID()==bookId) {
				return B;
			}
		}
		return null;
	}
	
	Member findMemberbyId(int memberId) {
		for(Member M :member) {
			if(M.getMemberId()==memberId) {
				return M;
			}
		}
		return null;
	}
	
	// issue and  return option
	
	public void issueBook(int bookid,int memberid,int transactionid) {
		 Book book =findBookbyId(bookid);	
		 Member member = findMemberbyId(memberid);
		 
		 if(book == null || member ==null) {
			 System.out.println("Invalid book or member");
			 return;
		 }
		 
		 if(!book.isAvailableStatus()) {
			 System.out.println("Book already issued");
			 return;
		 }
		 
		 book.markIssued();
		 
		 Transaction t = new Transaction(transactionid,"issue",book,member);
		 transaction.add(t);
		 System.out.println("Book issue successfully");
				 
	}
	
	public void returnBook(int bookid,int memberid,int transactionid) {
		
		 Book book =findBookbyId(bookid);	
		 Member member = findMemberbyId(memberid);
		 
		 if(book == null || member ==null) {
			 System.out.println("Invalid book or member");
			 return;
		 }
		 
		 book.markReturn();
		 
		 Transaction t = new Transaction(transactionid,"return",book,member);
		 transaction.add(t);
		 System.out.println("Book returned successfully");
				 
	}
	
	//show transaction
	
	public void displayTransactions() {

	    if (transaction.isEmpty()) {
	        System.out.println("No transactions available.");
	        return;
	    }

	    System.out.println("\n===== TRANSACTION HISTORY =====");
	    System.out.printf("%-15s %-18s %-12s %-10s%n",
	            "Transaction ID", "Member Name", "Book Name", "Type");

	    for (Transaction t : transaction) {
	        System.out.printf("%-15d %-18s %-12s %-10s%n",
	                t.getTranactionId(),
	                t.getMember().getMemberName(),
	                t.getBook().getBookTitle(),
	                t.getType());
	    }
	}

		
	// show book
		public void displayAllBooks() {
			for(Book B :books) {
				System.out.println( "BOOK ID: "+B.getBookID() +" BOOK NAME: "+B.getBookTitle()+"  STATUS :"+B.BookStatus());
			}
			
		}
	
	

}
