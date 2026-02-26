package com.library.management;

public class Member {
	
	private int memberId;
	private String memberName;
	
	public Member(int memberId,String memberName) {
		this.memberId =memberId;
		this.memberName =memberName;
		
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}
	
	

}
