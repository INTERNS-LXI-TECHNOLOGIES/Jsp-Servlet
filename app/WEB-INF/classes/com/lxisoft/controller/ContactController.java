package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import java.io.file;


public class ContactController{

	
public static Set<Contact> contactList=new HashSet<Contact>();

public void addContact(int id,String name, String phoneNumber, String place, String emailId){
	
	contactList.add(new Contact(id,name, phoneNumber, place, emailId));
	
	
	//contactList.add(new Contact("silpa", "9497582781", "palakkad", "silpa.s@gmail.com"));
	
	
}

public void editContact(int id,String name, String phoneNumber, String place, String emailId){
	
	boolean result=true;
	for(Contact contact:contactList){
		
			if(contact.id==id){
					contact.setName(name);
					contact.setPhoneNumber(phoneNumber);
					contact.setPlace(place);
					contact.setEmailId(emailId);
			}		
	
}
}

	public static Set<Contact> getContacts()
	{
		return  contactList;
	}


	
}