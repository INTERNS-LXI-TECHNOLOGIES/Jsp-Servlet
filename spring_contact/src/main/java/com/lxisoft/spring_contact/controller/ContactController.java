package com.lxisoft.spring_contact.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.spring_contact.model.Contact;
import com.lxisoft.spring_contact.service.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PutMapping
	public Contact create(@RequestBody Contact contact) {
		
		return contactService.create(contact);
	}

	@DeleteMapping("{id}")
	public void remove(@PathVariable int id) {
		
		contactService.remove(id);
	}
	
	@GetMapping()
	public List<Contact> read() {
	
		return contactService.read();
	}
	
	@GetMapping("{id}")
	public Optional<Contact> getContact(@PathVariable int id) {
		
		return contactService.getContact(id);
	}
	
	
}
