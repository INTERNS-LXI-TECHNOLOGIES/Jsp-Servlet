package com.lxisoft.orangeAlert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.orangeAlert.model.User;
import com.lxisoft.orangeAlert.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}	

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(userRepository.getOne(id));
	}

}
