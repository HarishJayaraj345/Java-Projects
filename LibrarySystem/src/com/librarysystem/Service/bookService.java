package com.librarysystem.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.librarysystem.model.Book;

class titlesort implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getTitle().compareToIgnoreCase(o2.getTitle());
	}
	
}

class idsort implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		if(o1.getId()>o2.getId()) return 1;
		else return -1;
	}
	
}

class yearsort implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getYear().compareTo(o2.getYear());
	}
	
}

public class bookService {
	
	List<Book> book;
	Map<Integer,Book> mapbook = new HashMap<>();
	
	public bookService() {
		book = new ArrayList<>();
	}
	
	//add book
	public void addBook(Book b) {
		book.add(b);
		mapbook.put(b.getId(), b);
		System.out.println(b.getTitle()+" "+"Added...");
	}
	
	//display all book
	public void DisplayAllBook() {
		System.out.println("---Library All Books---");
		for(Book b :book) {
			System.out.println(b.getId() +" "+b.getTitle()+" "+b.getAuthor()+ " "+b.getCategory()+" "+b.getYear());
		}
	}
	// display all uniq book
	public void uniqBook() {
		Set<Book> unique = new HashSet<>(book);
		for(Book b1 :unique) {
			System.out.println(b1.getId()+" "+b1.getTitle());
		}
		
		
	}
	 // book search by id
	public void searchBook(int id) {
		Book b2 = mapbook.get(id);
		System.out.println("book Details :"+b2.getId() +" "+b2.getTitle() +" "+b2.getAuthor() +" "+b2.getCategory()+ " "+b2.getYear());
	}
	
	
	// get all book by category wise
	public void categoryBook(String categoryname) {
		boolean check = false;
		System.out.println(categoryname+" Category Books");
		for(Book b3 : book) {
			if(!b3.getCategory().equals(categoryname)) {
				continue;
			}
			else {
				check = true;
				System.out.println("id "+b3.getId()+" Book Title :"+b3.getTitle());
			}
		}
		if(check!=true) {
			System.out.println("There is no Book in this category !");
		}
		
	}
	
	// get all book by author wise
	public void authorBook(String authorname) {
		boolean check = false;
		System.out.println(authorname+" Author Books");
		for(Book b4 : book) {
			if(!b4.getAuthor().equals(authorname)) {
				continue;
			}
			else {
				check = true;
				System.out.println("id "+b4.getId()+" Book Title :"+b4.getTitle());
			}
		}
		if(check!=true) {
			System.out.println("There is no Book in this author name !");
		}
		
	}
	
	//sort by title
	
	public void sortbytitle() {
		Collections.sort(book,new titlesort());
		System.out.println(book);
	}
	
	//sort by id
	
	public void sortbyid() {
		Collections.sort(book,new idsort());
		System.out.println(book);
	}
	
	//sort by year
	
	public void sortbyyear() {
		Collections.sort(book,new yearsort());
		System.out.println(book);
	}

}
