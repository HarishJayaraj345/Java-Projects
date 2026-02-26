package com.library.management;

public class Transaction {

	private int tranactionId;
	private String type;          //issue or return
	private Book book;
	private Member member;
	
	
	
	
	public Transaction(int tranactionId, String type, Book book, Member member) {
		this.tranactionId = tranactionId;
		this.type = type;
		this.book = book;
		this.member = member;
	}
	public int getTranactionId() {
		return tranactionId;
	}
	public String getType() {
		return type;
	}
	public Book getBook() {
		return book;
	}
	public Member getMember() {
		return member;
	}
		
	
}
