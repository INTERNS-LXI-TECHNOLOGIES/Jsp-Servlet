package com.lxisoft.spring_contact.service;

import java.util.List;
import java.util.Optional;

import com.lxisoft.spring_contact.model.Contact;

public interface ContactServiceIn {

	
	public Contact create(Contact contact);
	public void remove(int id);
	public List<Contact> read();
	public List<Contact> getContact(int id);
	
}
