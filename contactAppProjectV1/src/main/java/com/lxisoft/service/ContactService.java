package com.lxisoft.service;
import com.lxisoft.repository.ContactRepository;
import java.util.ArrayList;
import com.lxisoft.model.Contact;
import java.sql.*;

public class ContactService {
	
		Contact cont;
		ContactRepository contactRepo=new ContactRepository();
		
		public String addContact(Contact contact) throws SQLException{
			String result=contactRepo.insertContact(contact);
			//System.out.println(result);
			return result;
		}
		
		public ArrayList<Contact> getContact()throws SQLException{
			ArrayList<Contact> contactList = contactRepo.getContactList();
			return contactList;
		}
		public String remove(String name) throws SQLException{
			String result=contactRepo.delete(name);
			return result;
		}
		
		public String updateContact(String uFirstName,String uLastName,String uPhone,String uNumber,String uEmail) throws SQLException{
			//System.out.println(uFirstName+" "+uLastName+" "+" "+uPhone+" "+" "+uNumber+" "+" "+uEmail+" ");
			String result=contactRepo.update(uFirstName,uLastName,uPhone,uNumber,uEmail);
			return result;
		}
		
		public ArrayList<Contact> searchContact(String name) throws SQLException{
			ArrayList<Contact> li;
			li=contactRepo.search(name);
			return li;
		}

		public ArrayList searchContactId(String contact) throws SQLException {
			ArrayList list=contactRepo.getDetail(contact);
			return list;
		}
		
}
