package com.lxisoft.service;

import com.lxisoft.repository.ContactRepository;
import com.lxisoft.model.Contact;

public class ContactService{

	ContactRepository repo;

	public void addContact(Contact contact){

		repo.addToFile(contact);
	}
}