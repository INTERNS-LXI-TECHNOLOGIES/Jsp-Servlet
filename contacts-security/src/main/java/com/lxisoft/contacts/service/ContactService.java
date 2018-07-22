package com.lxisoft.contacts.service;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.SQLException;
import com.lxisoft.contacts.model.Contact;
import com.lxisoft.contacts.repository.ContactRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ContactService{

	private static final Logger LOGGER = LogManager.getLogger(ContactService.class.getName());
	private ContactRepository contactRepository = new ContactRepository();

	//CREATE CONTACT
	public void create(Contact contact) throws SQLException{
		LOGGER.info("create");
		contactRepository.save(contact);
	}
	
	//READ CONTACT
	public Contact read(String username) throws SQLException{
		LOGGER.info("read");
		Contact contact = contactRepository.findOne(username);
		return contact;
	}

	//READ ALL CONTACTS
	public List<Contact> readAll() throws SQLException{
		LOGGER.info("readAll");
		List<Contact> contactList = contactRepository.findAll();
		return contactList;
	}
	
	//UPDATE CONTACT
	public boolean update(Contact updatedContact) throws SQLException{
		LOGGER.info("update");	
		boolean updated = contactRepository.update(updatedContact);
		return updated;
	}
	
	//DELETE CONTACT
	public boolean delete(String username) throws SQLException{
		LOGGER.info("delete");
		boolean deleted = contactRepository.delete(username);
		return deleted;
	}


}















