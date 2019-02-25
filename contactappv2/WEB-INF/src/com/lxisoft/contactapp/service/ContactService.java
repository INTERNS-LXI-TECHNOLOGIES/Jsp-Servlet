package com.lxisoft.contactapp.service;
import com.lxisoft.contactapp.repository.ContactRepo;
import java.util.ArrayList;
import com.lxisoft.contactapp.model.Contact;
import java.io.*;


public class ContactService{
	
	ContactRepo contactRepo= new ContactRepo();
	ArrayList<Contact> contactList;
	Contact contact;
	public String save(String name,String phone,String number,String email){

		String a=contactRepo.addToFile(name,phone,number,email);
		System.out.println(a);
		return a;
	}
	
	public ArrayList<Contact> getContactList(){
		contactList = contactRepo.getFromFile();
		return contactList;
	}
	public String removeContact(String name) throws IOException{

		String delete=contactRepo.removeFromFile(name);
		return delete;
	}
	
	
	
	
}