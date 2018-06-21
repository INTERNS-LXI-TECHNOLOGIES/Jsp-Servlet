package com.lxisoft.controller;
import com.lxisoft.model.Contact;

import java.util.*;

public class NewContactController
{
	 private static boolean isAlreadyNotExist;
	static Set<Contact> contactSet =  new TreeSet<Contact>();;
	 
	 public static void addContact(String name,String place,String phn_no,String email)
	 {
	    
	   do{
	    contactSet.add(new Contact(name,place,phn_no,email));
		
	   }while(isAlreadyNotExist);
	   		   
		
	 }
	   //Iterator iterator = contactSet.iterator();
	   //while(iterator.hasNext())
	   //{
		   
	 /*  else
	   {
		   System.out.println("Already Exists!!!");
	   }*/
	  
	  // }
	  public static Set<Contact> contactDisplay()
	  {
		  System.out.println(contactSet.size());
		  return contactSet;
	  }
	  
	  public static Set<Contact>  deleteContact(String name)
	  {
		  for(Contact contacts:contactSet)
		  {
			  if(contacts.getFirstName()==name)
		  contactSet.remove(contacts); 
		  }
	  return contactSet;
		   
	  	
     /* public static void updateContact(String name,String place,String phn_no,String email)
       { 
	       for(Contact contacts:contactSet)
		   {
			   if(contacts.getFirstName()==name)
			   {
				contactSet.remove(contacts);
				contactSet.add(new Contact(name,place,phn_no,email));
			   }
			   
		   }
       }*/	
	 
	 
	  }
	 
	 
	 
}