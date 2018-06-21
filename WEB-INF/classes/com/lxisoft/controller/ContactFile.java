package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import java.io.*;

public class ContactFile
{
	
	public void addData(String name,String place,String phn_no,String email)
	{
		try
		{
		File file = new File("E:/apache-tomcat-7.0.72/webapps/ContactsApp/data");
		file.mkdir();
		File newFile = new File(file,"MyFile.csv");
		FileWriter fw = new FileWriter(newFile,true);
		PrintWriter buf = new PrintWriter(fw);
		buf.println(name+","+place+","+phn_no+","+email);
	
		buf.flush();
		buf.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	
	}
	
	public Set<Contact> readData()
	
	{
		String data="";
		 String[]  lines = null;
		  Set<Contact> contactSet = new TreeSet<Contact>();
			 
		try{
			File file = new File("E:/apache-tomcat-7.0.72/webapps/ContactsApp/data/MyFile.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		 while((data=br.readLine())!=null)
		 {
		 lines =  data.split(",");
		 /*Contact contact = new Contact();
		 contact.setFirstName(lines[0]);
		 contact.setPlace(lines[1]);
		 contact.setPhone_Number(lines[2]);
		 contact.setEmail_Id(lines[3]);*/
		 contactSet.add( new Contact(lines[0],lines[1],lines[2],lines[3]));
		 }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return contactSet;
		
	}
	
	public  void deleteData(String name)
	{
		Set<Contact> data = readData();
		
		
		boolean istrue = false;
		for(Contact contact:data)
		{
			//System.out.println(name+"  "+contact.getFirstName());
			
			if(contact.getFirstName().equals(name))
			{
				
				istrue=data.remove(contact);
			System.out.println(istrue);
			}
		}
		//File file = new File("E:/apache-tomcat-7.0.72/webapps/ContactsApp/data/MyFile.csv");
		
			writeToFile(data);
	}
	public void writeToFile(Set<Contact> contact)
	{
		
		try
		{
		File file = new File("E:/apache-tomcat-7.0.72/webapps/ContactsApp/data");
		file.mkdir();
		File newFile = new File(file,"MyFile.csv");
		for(Contact cts:contact)
		{
		FileWriter fw = new FileWriter(newFile);
		PrintWriter buf = new PrintWriter(fw,true);
		buf.println(cts.getFirstName()+","+cts.getPlace()+","+cts.getPhone_Number()+","+cts.getEmail_Id());
	
		buf.flush();
		buf.close();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		
	}
	
	public void editData(String name)
	{
		Set<Contact> contact = readData();
		for(Contact contacts:contact)
		{
			if(contacts.getFirstName().equals(name))
			{		
		      deleteData(name);
		      addData(contacts.getFirstName(),contacts.getPlace(),contacts.getPhone_Number(),contacts.getEmail_Id());
			}
		
		
	}
	
		
		
		
	}
	
	
	
	
	
	
	
