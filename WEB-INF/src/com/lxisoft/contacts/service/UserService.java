package com.lxisoft.contacts.service;
import com.lxisoft.contacts.model.*;
import java.io.*;
import java.util.Scanner;

public class UserService{

	//CREAT USER
	public void create(User user) throws SQLException{
		System.out.println("create_UserService");
		userRepository.save(user);
	}
	
	//READ USER
	public User read(int userId) throws SQLException{
		System.out.println("read_UserService");
		userRepository.findOne(userId);
	}

}