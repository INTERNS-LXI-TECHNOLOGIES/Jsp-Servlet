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
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}
	
	@Override
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	@Override
	public Optional<Contact> getContact(Long id) {
		return contactRepository.findById(id);
	}
	
	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void deleteContact(Long id) {
		contactRepository.delete(contactRepository.getOne(id));
	}
}
