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
	static FileService fileService=new FileService(); 
	Set<String> searchedContact;
	public void addContact(String name,String place,String phone,String email)
	{
		Contact c=new Contact();
		c.setName(name);
		c.setPlace(place);
		c.setPhoneNumber(phone);
		c.setEmail(email);
		fileService.writeToFile(c);
		/*boolean b=contacts.add(c);
		if(b==true)
		{
			return "success";
		}
		else
		{
			return "failed";
		}*/
	}
	public Set<Contact> viewContact()
	{
		Set<Contact> contact=fileService.readFromFile();
		return contact;
	}
	public void deleteContact(Contact c)
	{
		Set<Contact> contact=this.viewContact();
		contact.remove(c);
		fileService.rewriteToFile(contact);
	}
	public void editContact(Contact c,String name,String place,String phone,String email)
	{
		Set<Contact> contact=this.viewContact();
		for(Contact co:contact)
		{
			if(c.getName().equals(co.getName()))
			{
				co.setName(name);
				co.setPlace(place);
				co.setPhoneNumber(phone);
				co.setEmail(email);
			}
		}
		fileService.rewriteToFile(contact);
	}
	public Set<String> searchContact(String searchValue)
	{
		try{
		searchedContact=new TreeSet<String>();
		String s1="E:/Apache_Tomcat/apache-tomcat-7.0.72/webapps/contact_ruhail_v2/data/contacts.csv";
		Scanner fileScanner=new Scanner(new File(s1));
		Pattern p=Pattern.compile(searchValue);
		Matcher m=null;
		while(fileScanner.hasNextLine())
		{
			String str=fileScanner.nextLine();
			m=p.matcher(str);
			if(m.find())
			{
				searchedContact.add(str);
			}
		}
		
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		return searchedContact;
	}
}