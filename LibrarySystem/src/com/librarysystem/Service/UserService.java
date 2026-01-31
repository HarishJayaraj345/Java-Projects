package com.librarysystem.Service;

import java.util.ArrayList;
import java.util.List;

import com.librarysystem.model.User;

public class UserService {
	
	List<User> user;
	
	public UserService() {
		user = new ArrayList<>();
	}
	
	public void addBook(User u) {
		user.add(u);
	}

}
