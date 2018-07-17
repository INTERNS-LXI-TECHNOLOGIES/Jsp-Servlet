package com.lxisoft.controller;
import java.util.*;
import com.lxisoft.model.Contact;
import java.io.IOException; 
import org.apache.log4j.Logger;

/**
*All methods of this class are only for calling corresponding methods of DBService class.
*dbService is static reference to DBService class. 
*LOGGER object to do logging using log4j tool.

@version 1.6
@author ruhail
@since 2018-07-11
*/
public class ContactController
{
	static DBService dbService=new DBService(); 
	Set<String> searchedContact;
	private final static Logger LOGGER = Logger.getLogger(ContactController.class.getName());
	/**
	*passing contact object to DBService insertToDB method to insert contact to database.
	*it returns int value.
	*/
	public int addContact(Contact c)
	{
		LOGGER.info("------add contact started------");
		int res=dbService.insertToDB(c);
		LOGGER.info("------add contact completed------");
		return res;
	}
	/**
	*calling selectFromDB method of DBService class to read data from database.
	*it returns set of contacts.
	*/
	public Set<Contact> viewContact()
	{
		LOGGER.info("------view contact started------");
		Set<Contact> contact=dbService.selectFromDB();
		LOGGER.info("------view contact completed------");
		return contact;
	}
	/**
	*calling deleteFromDB method of DBService class to delete data from database.
	*it returns int value.
	*/
	public int deleteContact(Contact c)
	{
		LOGGER.info("-----delete contact started------");
		String nam=c.getName();
		int res=dbService.deleteFromDB(nam);
		LOGGER.info("------delete contact completed------");
		return res;
	}
	/**
	*calling updateDB method of DBService class to update database.
	*it returns int value.
	*/
	public int editContact(Contact c,String hidName)
	{
		LOGGER.info("------edit contact started------");
		int res=dbService.updateDB(c,hidName);
		LOGGER.info("------edit contact completed------");
		return res;
	}
	/**
	*calling searchFromDB method of DBService class to rsearch given data from database.
	*it returns set of contacts.
	*/
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