package com.lxisoft.spring_contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.spring_contact.model.Contact;
import com.lxisoft.spring_contact.repo.ContactRepo;

@Service
public class ContactService implements ContactServiceIn {
	
	@Autowired
	ContactRepo contactRepo;
	

	@Override
	public Contact create(Contact contact) {
		
		return contactRepo.save(contact);
	}

	@Override
	public void remove(int id) {
		
		contactRepo.deleteById(id);
	}

	@Override
	public List<Contact> read() {
	
		return contactRepo.findAll();
	}

	@Override
	public List<Contact> getContact(int id) {
		
		 Optional<Contact> a = contactRepo.findById(id);
		 List<Contact> searchedContact = new ArrayList<Contact>();
			Contact c = new Contact();
			c.setName(a.get().getName());
			c.setNumber(a.get().getNumber());
			c.setAdrs(a.get().getAdrs());
			searchedContact.add(c);
			return searchedContact;
			

	}
}
