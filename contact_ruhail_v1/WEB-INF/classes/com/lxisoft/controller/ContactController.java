package com.lxisoft.controller;
import java.util.*;
import com.lxisoft.model.Contact;
public class ContactController
{
	static Set<Contact> contacts=new TreeSet<Contact>();
	public String addContact(String name,String place,String phone,String email)
	{
		Contact c=new Contact();
		c.setName(name);
		c.setPlace(place);
		c.setPhoneNumber(phone);
		c.setEmail(email);
		boolean b=contacts.add(c);
		if(b==true)
		{
			return "success";
		}
		else
		{
			return "failed";
		}
	}
	public Set<Contact> viewContact()
	{
		return contacts;
	}
}