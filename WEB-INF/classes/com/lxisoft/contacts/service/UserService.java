package com.lxisoft.contacts.service;

import com.lxisoft.contacts.model.*;
import java.io.*;
import java.util.Scanner;
import java.sql.SQLException;
import com.lxisoft.contacts.repository.UserRepository;

public class UserService{

	private UserRepository userRepository = new UserRepository();

	//CREATE USER
	public boolean create(User user) throws SQLException{
		System.out.println("create_UserService");
		boolean created = userRepository.save(user);
		return created;
	}
	
	//READ USER
	public User read(String username, String password) throws SQLException{
		System.out.println("read_UserService");
		User user = userRepository.findOne(username, password);
		return user;
	}

}