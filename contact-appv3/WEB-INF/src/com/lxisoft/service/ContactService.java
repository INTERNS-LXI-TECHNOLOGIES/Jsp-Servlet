package com.lxisoft.service;

import java.io.IOException;
import java.util.ArrayList;
import com.lxisoft.repository.ContactRepository;
import com.lxisoft.model.Contact;
import java.sql.SQLException;

public class ContactService{

ContactRepository repo=new ContactRepository();
ArrayList<Contact> list;
ArrayList<String>  li;
	public String addContact(Contact contact) throws SQLException{
		
		String result=repo.addToDatabase(contact);
		return result;
	}
	public ArrayList<Contact> getContact() throws SQLException{

		list=repo.getFromDatabase();
		return list;

	}
	public String removeContact(String name) throws SQLException{

		String result=repo.deleteFromDatabase(name);
		return result;
	}
	public String editContact(String uname,String uphno) throws SQLException{

		String result=repo.editData(uname,uphno);
		return result;
	}
	public ArrayList<String> searchContact(String name) throws SQLException{
		
		li=repo.searchData(name);
		return li;
	}
}