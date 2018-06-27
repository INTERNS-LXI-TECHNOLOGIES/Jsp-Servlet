package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
public class ContactController{
	
	
	private static File contactData;
	
	public File getFile(){
		return contactData;
	}
	public void setFile(File contactData){
		this.contactData=contactData;
	}
	static
	{
		File dir=new File("C://apache-tomcat-7.0.72/webapps/contactsDb/data");
		contactData=new File(dir,"Data.csv");
		contactData.delete();
		
		
	}
	public  void save(int id,String name,String phone){
		
		try{
		File dir=new File("C://apache-tomcat-7.0.72/webapps/contactsDb/data");
		contactData=new File(dir,"Data.csv");
		contactData.createNewFile();
		BufferedWriter bw=new BufferedWriter(new FileWriter(contactData,true));
		bw.write(id+","+name+","+phone);
		bw.newLine();
		bw.flush();
		bw.close();
		}
		catch(IOException e){
			
			System.out.println();
		}
	}
public Contact search(String name){
		
		Contact contact=new Contact(0,"non","non");
		loop1:
		for(Contact tempContact:getContacts()){
			if(name.equalsIgnoreCase(tempContact.getName())){
					
					contact=tempContact;
					break loop1;
			}
		}
		return contact;
	}

	public ArrayList<Contact> getContacts(){
		
		
		ArrayList<Contact>contacts=new ArrayList<Contact>();
		
		try{
				if(contactData!=null)
				{
					BufferedReader br=new BufferedReader(new FileReader(contactData));//null is coming
					
					String data= null;
					
						while((data=br.readLine())!=null){
							
							String[]datas=data.split(",");
							
							int id=Integer.parseInt(datas[0]);
							contacts.add(new Contact(id,datas[1],datas[2]));
						}
						br.close();
				}
			}
		catch(IOException e){
			
			System.out.println("getContacts/ "+e);
			
		}
		
		return contacts;
		
	}
	public void check(int id,String name,String phone)//to check what action is to be perfomed edit or saving
	{
		ArrayList<Contact>contacts=getContacts();
		boolean isToSave=true;
		loop1:
		for(Contact tempContact:getContacts()){
			System.out.println("\n"+" cc/check "+id+" "+tempContact.id+"\n");
			if(id==tempContact.id){
					System.out.println("\n"+" gonne to edit method"+"\n");
					edit(id,name,phone);
					isToSave=false;
					System.out.println("\n"+" gonne to edit method");
					break loop1;
			}
		}
		if(isToSave){
			save(id,name,phone);
		}
		
	}
	public void edit(int id1,String name,String phone){//reding all data,storing and editing the data .deleteing old data file saveing all data into the file by calling save
		ArrayList<ArrayList<String>>contactsFile=new ArrayList<ArrayList<String>>();
		try{
			BufferedReader br=new BufferedReader(new FileReader(contactData));
			String contactFile=null;
			while((contactFile=br.readLine())!=null)
			{
				ArrayList<String>rowData=new ArrayList<String>();
				
				String []field=contactFile.split(",");
				
					int tempId=Integer.parseInt(field[0]);
					if(id1==tempId)
					{
						System.out.println(">>>>>>>>>>>>>>>>>>>>"+"\n"+"\n"+" gonne to edit method");
						System.out.println("affter edit[]"+id1+name+phone);
						System.out.println("befor edit[]"+field[0]+field[1]);
						rowData.add(field[0]);
						rowData.add(name);
						rowData.add(phone);
						
						
					}
					else
					{
						rowData.add(field[0]);
						rowData.add(field[1]);
						rowData.add(field[2]);
						 
					}
				contactsFile.add(rowData);
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("edit/Exception "+e);
		}
		
		contactData.delete();
		for(ArrayList<String>rowData:contactsFile){
			int tempId=Integer.parseInt(rowData.get(0));
			save(tempId,rowData.get(1),rowData.get(2));
			
		}
		
		
	}
	public void remove(int id){//
		ArrayList<ArrayList<String>>contactsFile=new ArrayList<ArrayList<String>>();
		try{
			try{
			BufferedReader br=new BufferedReader(new FileReader(contactData));
			String contactFile=null;
			while((contactFile=br.readLine())!=null){
				ArrayList<String>rowData=new ArrayList<String>();
				
					String []field=contactFile.split(",");
					int tempId=Integer.parseInt(field[0]);
					if(id==tempId)
					{
						continue;
					}
					else
					{
						
						rowData.add(field[0]);
						rowData.add(field[1]);
						rowData.add(field[2]);
						 
					}
				contactsFile.add(rowData);
			}
			br.close();
			}
			catch(NullPointerException ep){
				System.out.println("cc/remove/1st/ "+ep+"/n");
			}
		}
		catch(IOException e)
		{
			System.out.println("edit/Exception "+e+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+"/n"+"/n");
		}
		System.out.println("delete is ="+contactData.delete());
		try{
			System.out.println("cc/remove/2loop st/ "+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+"/n"+"/n");

			for(ArrayList<String>rowData:contactsFile){
				System.out.println(rowData.get(0)+rowData.get(1)+rowData.get(2));
				int tempId=Integer.parseInt(rowData.get(0));
				save(tempId,rowData.get(1),rowData.get(2));
				
			}
		}
		catch(Exception ep){
				System.out.println("cc/remove/2st/ "+ep+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+"/n"+"/n");
			}
		
		
		
	}
}