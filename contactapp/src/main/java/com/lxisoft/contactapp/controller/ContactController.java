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
	
	@PostMapping("/api/new")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws URISyntaxException{
		
		Contact result=contactService.createContact(contact);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-contact-created", result.toString())
				.body(result);
		
	}
	@GetMapping("/api/get/{id}")
	public ResponseEntity<Contact> readContact(@PathVariable Integer id) {
	
		Optional<Contact> result = contactService.getContact(id);
		return ResponseEntity.of(result);
	}
	@GetMapping("/api/get")
	public ResponseEntity<List<Contact>> readAllContacts() {
	
		List<Contact> result = contactService.getAllContacts();
		return ResponseEntity.ok()
				.body(result);
	}
	@PutMapping("/api/update")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) throws URISyntaxException {
		if(contact.getId()!=0)
		{
			Contact result = contactService.updateContact(contact);
			return ResponseEntity.ok()
		            .header("X-contact-updated", result.toString())
		            .body(result);
		}
		return ResponseEntity.badRequest()
				.body(null);
	}
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {
		
		contactService.deleteContact(id);
		return ResponseEntity.ok()
		.header("X-contact-deleted", id.toString())
		.build();
	}

}
