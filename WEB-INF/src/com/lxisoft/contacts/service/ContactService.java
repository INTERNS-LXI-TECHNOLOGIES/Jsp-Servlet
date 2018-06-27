package com.lxisoft.contacts.service;

import com.lxisoft.contacts.model.Contact;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactService{
	
	//CONSTRUCTOR
	public ContactService(String url, String username, String password) throws SQLException{
		System.out.println("constructor_ContactService");
		ContactRepository contactRepository = new ContactRepository(url, username, password);
	}

	//CREATE CONTACT
	public void create(Contact contact) throws SQLException{
		System.out.println("create_ContactService");
		contactRepository.save(contact);
	}
	
	//READ CONTACT
	public Contact read(int userId) throws SQLException{
		System.out.println("read_ContactService");
		contactRepository.findOne(userId);
	}

	//READ ALL CONTACTS
	public List<Contact> readAll() throws SQLException{
		System.out.println("readAll_ContactService");
		List<Contact> contactList = contactRepository.findAll();
		return contactList;
	}
	
	//UPDATE CONTACT
	public void update(Contact updatedContact) throws SQLException{
		System.out.println("update_ContactService");	
		contactRepository.update(updatedContact);
	}
	
	//DELETE CONTACT
	public void delete(int userId) throws SQLException{
		System.out.println("delete_ContactService");
			contactRepository.delete(userId);
	}


}















