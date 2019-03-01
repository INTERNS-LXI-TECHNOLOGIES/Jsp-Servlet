package com.lxisoft.contactapp.service;
import com.lxisoft.contactapp.repository.ContactRepository;
import java.util.ArrayList;
import com.lxisoft.contactapp.model.Contact;
import java.io.*;


public class ContactService{
	
	ContactRepository contactRepo= new ContactRepository();
	ArrayList<Contact> contactList;
	Contact cont;
	public String addContact(String name,String phone,String number,String email){

		String a=contactRepo.save(name,phone,number,email);
		System.out.println(a);
		return a;
	}
	
	public ArrayList<Contact> getContactList(){
		contactList = contactRepo.getFromFile();
		return contactList;
	}
	public String remove(String name) throws IOException{
		String result=contactRepo.delete(name);
		System.out.println(result);
		return result;
	}
	
	public String update(String updateName,String updatePhone,String updateNumber,String updateEmail) throws IOException{
		ArrayList<Contact> clist;
		clist=contactRepo.getFromFile();
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
	
}