package com.lxisoft.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lxisoft.model.ContactDetails;

public class ContactRepo {
	
	public List<ContactDetails> getContact(String name) throws SQLException, ClassNotFoundException { 
		List<ContactDetails> contacts = new ArrayList<ContactDetails>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/contactuser","root","root");
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from "+name);
		while(r.next()) {
			ContactDetails contact = new ContactDetails();
			contact.setName(r.getString("name"));
			contact.setEmailid(r.getString("emailid"));
			contact.setNumber(r.getString("number"));
			contacts.add(contact);
			
		}
		return contacts;
		
	}

	public List<ContactDetails> getSearchContact(String name, String search) throws SQLException, ClassNotFoundException {
		List<ContactDetails> contacts = new ArrayList<ContactDetails>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/contactuser","root","root");
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from "+name+" where name like '%"+search+"%'");
		
		while(r.next()) {
			ContactDetails contact = new ContactDetails();
			contact.setName(r.getString("name"));
			contact.setEmailid(r.getString("emailid"));
			contact.setNumber(r.getString("number"));
			contacts.add(contact);
			
		}
		return contacts;
	}
	
}
