package com.lxisoft.contactapp.service;
import com.lxisoft.contactapp.repository.ContactRepo;
import java.util.ArrayList;
import com.lxisoft.contactapp.model.Contact;


public class ContactService{
	
	ContactRepo contactRepo= new ContactRepo();
	ArrayList<Contact> contactList;
	Contact contact;
	public void save(String name,String phone,String number,String email){
		contact=new Contact(name,phone,number,email);
		contactRepo.addToFile(name,phone,number,email);
		
		
	}
	
	
	
	
	
}