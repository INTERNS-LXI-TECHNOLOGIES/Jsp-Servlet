package com.lxisoft.facegram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lxisoft.facegram.controller.UserPrincipal;
import com.lxisoft.facegram.model.User;
import com.lxisoft.facegram.repo.UserRepo;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		System.out.println(user);
		System.out.println(username);
		return new UserPrincipal(user);
	}
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	
	
}
