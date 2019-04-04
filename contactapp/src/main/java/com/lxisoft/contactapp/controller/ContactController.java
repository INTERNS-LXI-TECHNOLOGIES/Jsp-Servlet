package com.lxisoft.contactapp.controller;

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

import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;
	/**
	 * Create new contact
	 * @param contact
	 * @return ResponseEntity.created()
	 * @throws URISyntaxException
	 */
	@PostMapping("/api/create")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws URISyntaxException {
		Contact result = contactService.createContact(contact);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-contact-created", result.toString())
				.body(result);
	}
	/**
	 * Read all contacts
	 * @return ResponseEntity.ok()
	 */
	
	@GetMapping("/api/get")
	public ResponseEntity<List<Contact>> readAllContacts() {
	
		List<Contact> result = contactService.getAllContacts();
		return ResponseEntity.ok()
				.body(result);
	}
	
	/**
	 * Read contact by id
	 * @param id
	 * @return
	 */
	@GetMapping("/api/get/{id}")
	public ResponseEntity<Contact> readContact(@PathVariable Long id) {
		Optional<Contact> result = contactService.getContact(id);
		return ResponseEntity.of(result);
	}
	/**
	 * Update contact
	 * @param contact
	 * @return
	 * @throws URISyntaxException
	 */
	
	@PutMapping("/api/update")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) throws URISyntaxException {
		if(contact.getId() != null)
		{
			Contact result = contactService.updateContact(contact);
			return ResponseEntity.ok()
		            .header("X-contact-updated", result.toString())
		            .body(result);
		}
		return ResponseEntity.badRequest()
				.body(null);
	}
	/**
	 * Delete contact
	 * @param id
	 * @return
	 */
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
		contactService.deleteContact(id);
		return ResponseEntity.ok()
		.header("X-contact-deleted", id.toString())
		.build();
	}
	
	
}