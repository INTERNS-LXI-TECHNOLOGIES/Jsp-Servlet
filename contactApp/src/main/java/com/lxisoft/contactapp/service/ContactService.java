package com.lxisoft.contactapp.service;
import com.lxisoft.contactapp.repository.ContactRepository;
import java.util.ArrayList;
import com.lxisoft.contactapp.model.Contact;
import java.io.*;


public class ContactService{
		
	Contact cont;
	ContactRepository contactRepo=new ContactRepository();
	
	public String addContact(Contact contact){
		String result=contactRepo.save(contact);
		return result;
	}
	
	public ArrayList<Contact> getContact(){
		ArrayList<Contact> contactList = contactRepo.getContactList();
		return contactList;
	}
	
	public String update(String updateName,String updatePhone,String updateNumber,String updateEmail){
		ArrayList<Contact> clist;
		clist=contactRepo.getContactList();
		for(int i=0;i<clist.size();i++){
			if((clist.get(i).getName().equals(updateName))||(clist.get(i).getNumber().equals(updateNumber))){
				cont=new Contact(updateName,updatePhone,updateNumber,updateEmail);
				clist.set(i,cont);
			}
		}
		String result=contactRepo.update(clist);
		System.out.println(result);
		return result;
	}
	
	public ArrayList<Contact> searchContact(String name){
		ArrayList<Contact> li;
		li=contactRepo.search(name);
		return li;
	}
	
	public String remove(String name){
		String result=contactRepo.delete(name);
		System.out.println(result);
		return result;
	}

	
}