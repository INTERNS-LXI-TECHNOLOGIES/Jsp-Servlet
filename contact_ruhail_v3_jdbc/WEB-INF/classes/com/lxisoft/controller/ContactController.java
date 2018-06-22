package com.lxisoft.controller;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.File;
import com.lxisoft.model.Contact;
import java.io.IOException; 
public class ContactController
{
	//static Set<Contact> contacts=new TreeSet<Contact>();
	static DBService dbService=new DBService(); 
	Set<String> searchedContact;
	public void addContact(String name,String place,String phone,String email)
	{
		Contact c=new Contact();
		c.setName(name);
		c.setPlace(place);
		c.setPhoneNumber(phone);
		c.setEmail(email);
		dbService.insertToDB(c);
	}
	public Set<Contact> viewContact()
	{
		Set<Contact> contact=dbService.selectFromDB();
		return contact;
	}
	public Set<Contact> deleteContact(Contact c)
	{
		String nam=c.getName();
		int res=dbService.deleteFromDB(nam);
		Set<Contact> contact=viewContact();
		return contact;
	}
	public void editContact(Contact c,String hidName)
	{
		int res=dbService.updateDB(c,hidName);
	}
	public Set<Contact> searchContact(String searchValue)
	{
		Set<Contact> searchedContact=null;
		try
		{
			searchedContact=dbService.searchFromDB(searchValue);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return searchedContact;
	}
}