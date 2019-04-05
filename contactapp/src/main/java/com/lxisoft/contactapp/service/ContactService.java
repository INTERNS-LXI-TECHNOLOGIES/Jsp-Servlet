package com.lxisoft.contactapp.service;

import java.util.List;
import java.util.Optional;

import com.lxisoft.contactapp.model.Contact;

public interface ContactService {
	
	public Contact createContact(Contact contact);
	List<Contact> viewContact(List<Contact> contact);
	public Optional<Contact> getContact(Integer id);
	public List<Contact> getAllContacts();
	public Contact updateContact(Contact contact);
	public void deleteContact(Integer id);
}
