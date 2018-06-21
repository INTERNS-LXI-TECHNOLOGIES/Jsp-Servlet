package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;


public class ContactController{

	
public static Set<Contact> contactList=new HashSet<Contact>();

public void addContact(int id,String name, String phoneNumber, String place, String emailId){
	boolean result=true;
	for(Contact contact:contactList){
		
	if(id==contact.id){
		contact=new Contact(id,name, phoneNumber, place, emailId);
		result=false;
		}
	}
	if(result==true){
	contactList.add(new Contact(id,name, phoneNumber, place, emailId));
	}
	//contactList.add(new Contact("silpa", "9497582781", "palakkad", "silpa.s@gmail.com"));
	
	
}



	public static Set<Contact> getContacts()
	{
		return  contactList;
	}


	
}