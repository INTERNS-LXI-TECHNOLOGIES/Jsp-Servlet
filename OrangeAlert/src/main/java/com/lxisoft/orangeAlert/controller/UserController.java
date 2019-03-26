package com.lxisoft.orangeAlert.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.orangeAlert.model.User;
import com.lxisoft.orangeAlert.service.UserService;




/**
 * This is a REST controller that handles all the CRUD operations
 * related to the 'contacts' entity.
 * 
 * 
 * @author Ansal Khan
 * @version 1.0
 * @since 2019-03-05
 *
 */

/**
 * Given Annotation @RestController to make the class a REST Controller.
 */
@RestController
public class UserController {
	
	/**
	 * Autowired service reference of the contact domain (Interface ContactService).
	 * Used for  accessing the services defined in the ContactServiceImpl.
	 * Spring injects the Bean of  the implementer class 'ContactServiceImpl', since we've given the annotation @Service on that class.
	 */
	@Autowired
	UserService userService;
	
	/**
	 * SL4J logger used to enable logging of events and Rest calls.
	 */
	
	
	
	/**
	 * Used to map POST requests for creating contacts.
	 * 
	 * @param contact Object of the model class Contact, to be saved.
	 * @return ResponseEntity<Contact> embedded with saved contact along with generated id field (contact.id)
	 * @throws URISyntaxException, possible when using new URI
	 */
	@PostMapping("/api/new")
	public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
		
		User result = userService.createUser(user);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-user-created", result.toString())
				.body(result);
	}
	
	/**
	 * Used to map GET request for an individual contact.
	 * 
	 * @param id, of the contact to be accessed. Accepts the id of the particular contact to be fetched, as a path variable.
	 * @return ResponseEntity<Contact> embedded with the fetched contact.
	 */
	@GetMapping("/api/get/{id}")
	public ResponseEntity<User> readUser(@PathVariable Long id) {
		
		Optional<User> result = userService.getUser(id);
		return ResponseEntity.of(result);
	}
	
	/**
	 * Used to map GET request for the list of all contacts in the database.
	 * 
	 * @return ResponseEntity<List<Contact>> embedded with list of all of the contacts in database.
	 */
	@GetMapping("/api/get")
	public ResponseEntity<List<User>> readAllUsers() {
		
		List<User> result = userService.getAllUsers();
		return ResponseEntity.ok()
				.body(result);
	}
	
	/**
	 * Used to map PUT requests for editing a particular contact
	 * 
	 * @param contact, The contact to be updated, assumes that the object contains updated values.
	 * @return ResponseEntity<Contact> embedded with the updated contact.
	 * @throws URISyntaxException possible when creating a new URI.
	 */
	@PutMapping("/api/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws URISyntaxException {
		
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
	
	
	/** 
	 * Used to map DELETE requests, for deleting a contact entry from the database.
	 * 
	 * @param id, The id attribute of the contact intended to be deleted. Passed as a path variable.
	 * @return ResponseEntity<Void>  which wraps nothing. Howbeit, the required headers to show the request was successful is added.
	 */
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		
		userService.deleteUser(id);
		return ResponseEntity.ok()
		.header("X-user-deleted", id.toString())
		.build();
	}
}
