package com.lxisoft.contacts.service;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.SQLException;
import com.lxisoft.contacts.model.Contact;
import com.lxisoft.contacts.repository.ContactRepository;

public class ContactService{

	private ContactRepository contactRepository = new ContactRepository();

	//CREATE CONTACT
	public void create(Contact contact) throws SQLException{
		System.out.println("create_ContactService");
		contactRepository.save(contact);
	}
	
	//READ CONTACT
	public Contact read(int userId) throws SQLException{
		System.out.println("read_ContactService");
		Contact contact = contactRepository.findOne(userId);
		return contact;
	}

	//READ ALL CONTACTS
	public List<Contact> readAll() throws SQLException{
		System.out.println("readAll_ContactService");
		List<Contact> contactList = contactRepository.findAll();
		return contactList;
	}
	
	//UPDATE CONTACT
	public boolean update(Contact updatedContact) throws SQLException{
		System.out.println("update_ContactService");	
		boolean updated = contactRepository.update(updatedContact);
		return updated;
	}
	
	//DELETE CONTACT
	public boolean delete(int userId) throws SQLException{
		System.out.println("delete_ContactService");
		boolean deleted = contactRepository.delete(userId);
		return deleted;
	}


}















