package com.lxisoft.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.lxisoft.model.ContactDetails;

public class ContactRepo {
	DataSource ds = RepoDataSource.getMySQLDataSource();
	public List<ContactDetails> getContact(String name) throws SQLException, ClassNotFoundException { 
		List<ContactDetails> contacts = new ArrayList<ContactDetails>();
		Connection c = ds.getConnection();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from "+name);
		while(r.next()) {
			ContactDetails contact = new ContactDetails();
			contact.setId(r.getString("id"));
			contact.setName(r.getString("name"));
			contact.setEmailid(r.getString("emailid"));
			contact.setNumber(r.getString("number"));
			contacts.add(contact);
			
		}
		return contacts;
		
	}

	public List<ContactDetails> getSearchContact(String name, String search) throws SQLException, ClassNotFoundException {
		List<ContactDetails> contacts = new ArrayList<ContactDetails>();
		Connection c = ds.getConnection();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from "+name+" where name like '%"+search+"%'");
		
		while(r.next()) {
			ContactDetails contact = new ContactDetails();
			contact.setId(r.getString("id"));
			contact.setName(r.getString("name"));
			contact.setEmailid(r.getString("emailid"));
			contact.setNumber(r.getString("number"));
			contacts.add(contact);
			
		}
		return contacts;
	}
	
	public void addContact(ContactDetails contact,String username) throws SQLException, ClassNotFoundException {
		
		Connection c = ds.getConnection();
		PreparedStatement p = c.prepareStatement("insert into "+username+"(name,emailid,number) values(?,?,?)");
		p.setString(1,contact.getName());
		p.setString(2,contact.getEmailid());
		p.setString(3,contact.getNumber());
		p.execute();
		
		
	}
	public void deleteContact(String id,String username) throws ClassNotFoundException, SQLException {
		Connection c = ds.getConnection();
		PreparedStatement p = c.prepareStatement("delete from "+username+" Where id = ?");
		p.setString(1,id);
		p.execute();
	}
	
	public void editContact(ContactDetails contact,String username) throws SQLException, ClassNotFoundException {
		Connection c = ds.getConnection();
		PreparedStatement p = c.prepareStatement("update "+username+" set name = ?,emailid = ?,number = ? WHERE id = ?");
		p.setString(1,contact.getName());
		p.setString(2,contact.getEmailid());
		p.setString(3,contact.getNumber());
		p.setString(4,contact.getId());
		p.execute();
	}
	
}
