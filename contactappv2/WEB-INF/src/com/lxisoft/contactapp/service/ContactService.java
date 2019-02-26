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
	
	public String update(String updateName,String updatePhone,String updateNumber,String updateEmail) throws IOException{
		ArrayList<Contact> clist;
		clist=contactRepo.getFromFile();
		for(int i=0;i<clist.size();i++){
			
			if((clist.get(i).getName()==updateName)||(clist.get(i).getPhone()==updatePhone)||(clist.get(i).getNumber()==updateNumber)||(clist.get(i).getEmail()==updateEmail)){
				
				contact=new Contact(updateName,updatePhone,updateNumber,updateEmail);
				clist.set(i,contact);
			}
			
		}
		
		String update=contactRepo.updateFile(clist);
		System.out.println(update);
		return update;
	}
	
}