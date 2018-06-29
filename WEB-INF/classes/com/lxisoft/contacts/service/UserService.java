package com.lxisoft.contacts.service;

import com.lxisoft.contacts.model.*;
import java.io.*;
import java.util.Scanner;
import java.sql.SQLException;
import com.lxisoft.contacts.repository.UserRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserService{
	
	private static final Logger LOGGER = LogManager.getLogger(UserService.class.getName());
	private UserRepository userRepository = new UserRepository();

	//CREATE USER
	public boolean create(User user) throws SQLException{
		LOGGER.info("create");
		boolean created = userRepository.save(user);
		return created;
	}
	
	//READ USER
	public User read(String username, String password) throws SQLException{
		LOGGER.info("read");
		User user = userRepository.findOne(username, password);
		return user;
	}

}