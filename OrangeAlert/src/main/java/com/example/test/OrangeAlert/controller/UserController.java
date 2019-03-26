package com.example.test.OrangeAlert.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.OrangeAlert.model.User;
import com.example.test.OrangeAlert.service.UserService;


@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	
	
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	@PostMapping("/api/create")
	public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
		log.debug("Rest POST request to create new user: {}",user);
		User result = userService.createUser(user);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-user-created", result.toString())
				.body(result);
	}
	
	
	@GetMapping("/api/get/{u_id}")
	public ResponseEntity<User> readUser(@PathVariable Long u_id) {
		log.debug("REST request to GET User : {}", u_id);
		Optional<User> result = userService.getUser(u_id);
		return ResponseEntity.of(result);
	}
	
	
	@GetMapping("/api/get")
	public ResponseEntity<List<User>> readAllUser() {
		log.debug("REST request to GET all User");
		List<User> result = userService.getAllUsers();
		return ResponseEntity.ok()
				.body(result);
	}
	
	
	@PutMapping("/api/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws URISyntaxException {
		log.debug("REST PUT request to update User : {}", user);
		if(user.getId() != null)
		{
			User result = userService.updateUser(user);
			return ResponseEntity.ok()
		            .header("X-user-updated", result.toString())
		            .body(result);
		}
		return ResponseEntity.badRequest()
				.body(null);
	}
	
	
	 
	@DeleteMapping("/api/delete/{u_id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long u_id) {
		log.debug("REST request to delete Contact : {}", u_id);
		userService.deleteUser(u_id);
		return ResponseEntity.ok()
		.header("X-user-deleted", u_id.toString())
		.build();
	}
}
