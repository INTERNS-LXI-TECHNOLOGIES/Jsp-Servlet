package com.lxisoft.service;

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
}