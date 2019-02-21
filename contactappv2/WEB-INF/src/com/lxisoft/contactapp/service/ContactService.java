package com.lxisoft.contactapp.service;
import com.lxisoft.contactapp.repository.ContactRepo;
import java.util.ArrayList;
import com.lxisoft.contactapp.model.Contact;


public class ContactService{
	
	ContactRepo contactRepo= new ContactRepo();
	ArrayList<Contact> contactList;
	Contact contact;
	public String save(String name,String phone,String number,String email){

	
		String a=contactRepo.addToFile(name,phone,number,email);
		System.out.println(a);
		return a;
	}
	
	public void viewContactList(){
		
		contactList = contactRepo.loadFile();
		
		/*For(Contact contact : contactList){
			System.out.println(contact.getName());
		}*/
	}
	
	
	
	
	
}