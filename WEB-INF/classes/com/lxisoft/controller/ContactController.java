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
	public int addContact(String name,String place,String phone,String email)
	{
		Contact c=new Contact();
		c.setName(name);
		c.setPlace(place);
		c.setPhoneNumber(phone);
		c.setEmail(email);
		int res=dbService.insertToDB(c);
		return res;
	}
	public Set<Contact> viewContact()
	{
		Set<Contact> contact=dbService.selectFromDB();
		return contact;
	}
	public int deleteContact(Contact c)
	{
		String nam=c.getName();
		int res=dbService.deleteFromDB(nam);
		return res;
	}
	public int editContact(Contact c,String hidName)
	{
		int res=dbService.updateDB(c,hidName);
		return res;
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