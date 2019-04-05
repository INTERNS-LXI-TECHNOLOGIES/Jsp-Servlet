package com.lxisoft.contactapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	@Override
	public Contact createContact(Contact contact) {

		 return contactRepository.save(contact);
		
	}
	@Override
	public List<Contact> viewContact(List<Contact> contact) {
		
		return contactRepository.findAll();
	}
	@Override
	public Optional<Contact> getContact(Integer id) {
		
		return contactRepository.findById(id);
	}
	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}	

	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void deleteContact(Integer id) {
		contactRepository.delete(contactRepository.getOne(id));
	}

}
