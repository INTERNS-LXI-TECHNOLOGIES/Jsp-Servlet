package com.lxisoft.service;

import java.io.IOException;
import java.util.ArrayList;
import com.lxisoft.repository.ContactRepository;
import com.lxisoft.model.Contact;

public class ContactService{

	ContactRepository repo=new ContactRepository();
	ArrayList<Contact> conList;

	public String  addContact(Contact contact){

		String save=repo.addToFile(contact);
		return save;
	}
	public ArrayList<Contact> getContact(){

		conList=repo.getFromFile();
		return conList;
	}
	public String removeContact(String name){

		String delete=repo.removeFromFile(name);
		return delete;
	}
	public String  searchContact(String name){

		String phno=repo.searchFromFile(name);
		return phno;
	}
}