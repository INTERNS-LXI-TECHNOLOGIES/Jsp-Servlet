package com.example.test.OrangeAlert.service;

import java.util.List;
import java.util.Optional;

import com.example.test.OrangeAlert.model.User;

public interface UserService {
	User createUser(User user);

	Optional<User> getUser(Long id); 

	List<User> getAllUsers();

	User updateUser(User user);
	void deleteUser(Long id);

}
