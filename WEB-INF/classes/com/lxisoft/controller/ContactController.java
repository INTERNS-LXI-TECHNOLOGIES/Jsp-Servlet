package com.lxisoft.controller;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.File;
import com.lxisoft.model.Contact;
import java.io.IOException; 
import java.util.logging.Logger;

public class ContactController
{
	//static Set<Contact> contacts=new TreeSet<Contact>();
	static DBService dbService=new DBService(); 
	Set<String> searchedContact;
	private final static Logger LOGGER = Logger.getLogger(ContactController.class.getName());
	
	public int addContact(Contact c)
	{
		LOGGER.info("------add contact started------");
		int res=dbService.insertToDB(c);
		LOGGER.info("------add contact completed------");
		return res;
	}
	public Set<Contact> viewContact()
	{
		LOGGER.info("------view contact started------");
		Set<Contact> contact=dbService.selectFromDB();
		LOGGER.info("------view contact completed------");
		return contact;
	}
	public int deleteContact(Contact c)
	{
		LOGGER.info("-----delete contact started------");
		String nam=c.getName();
		int res=dbService.deleteFromDB(nam);
		LOGGER.info("------delete contact completed------");
		return res;
	}
	public int editContact(Contact c,String hidName)
	{
		LOGGER.info("------edit contact started------");
		int res=dbService.updateDB(c,hidName);
		LOGGER.info("------edit contact completed------");
		return res;
	}
	public Set<Contact> searchContact(String searchValue)
	{
		LOGGER.info("------search contact started-------");
		Set<Contact> searchedContact=null;
		try
		{
			searchedContact=dbService.searchFromDB(searchValue);
			LOGGER.info("------ search contact completed------");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return searchedContact;
	}
}