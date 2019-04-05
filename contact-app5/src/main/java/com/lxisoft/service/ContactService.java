package com.lxisoft.service;

import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.lxisoft.repository.ContactRepository;
import com.lxisoft.model.Contact;
import java.sql.SQLException;

public class ContactService{
	static Logger LOGGER=Logger.getLogger(ContactService.class.getName());
	ContactRepository repo=new ContactRepository();
	ArrayList<Contact> list;
	ArrayList<String>  li;
	public String addContact(Contact contact) throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		String result="";
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			result=repo.addToDatabase(contact);
			LOGGER.info(">Contact passing");
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Contact> getContact() throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		String result="";
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			list=repo.getFromDatabase();
			LOGGER.info(">Contact getting");
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return list;

	}
	public String removeContact(String name) throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		String result="";
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			result=repo.deleteFromDatabase(name);
			LOGGER.info(">Contact deleting");
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
			
		}
		return result;
	}
	public String editContact(String upName,String uname,String uphno) throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		String result="";
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			result=repo.editData(upName,uname,uphno);
			LOGGER.info(">Contact updating");
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<String> searchContact(String name) throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		String result="";
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			li=repo.searchData(name);
			LOGGER.info(">Contact searching");
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return li;
	}
}