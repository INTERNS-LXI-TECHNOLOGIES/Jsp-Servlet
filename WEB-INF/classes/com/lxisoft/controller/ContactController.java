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
		File dir=new File("C://apache-tomcat-7.0.72/webapps/ContactsFile/data");
		contactData= new File(dir,"Data.csv");
		contactData.delete();
		
		
	}
	public  void save(int id,String name,String phone)
	{
		
		try{
		File dir=new File("C://apache-tomcat-7.0.72/webapps/ContactsFile/data");
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
		
		Contact contact= new Contact(0,"non","non");
		loop1:
		for(Contact tempContact:getContacts()){
			if(name.equalsIgnoreCase(tempContact.getName())){
					
					contact=tempContact;
					break loop1;
			}
		}
		return contact;
	}
		

	public  ArrayList<Contact> getContacts(){
		ArrayList<Contact>contacts=new ArrayList<Contact>();
		File dir=new File("C://apache-tomcat-7.0.72/webapps/ContactsFile/data");
		File contactDatas=new File(dir,"Data.csv");
		Contact[] contactsTemp=new Contact[10];
		
		try{
				if(contactDatas!=null)
				{
					BufferedReader br=new BufferedReader(new FileReader(contactDatas));//null is coming
					
					String data= null;
					int i=0;
						while((data=br.readLine())!=null){
										System.out.println("looooppppppppppppppppppppp" +i);
							String[]datas=data.split(",");
							System.out.println("Contact-From file Reading +++++++++++++++++"+datas[0]+datas[1]+datas[2]);
							int id=Integer.parseInt(datas[0]);
							Contact c =new Contact(id,datas[1],datas[2]);
							contactsTemp[i]=c;
							//System.out.println("In list while loop "+contacts.get(i).getName()+" and size is "+contacts.size());
				
					i++;
						}
						br.close();
						
						
				}
			}
		catch(IOException e){
			
			System.out.println("getContacts/ "+e);
			
		}

			
		for(Contact contact:contactsTemp){
			if(contact!=null){
			System.out.println("in list  +++++"+contact.getName());
			contacts.add(contact);
			}
			
		}
			
		
		return contacts;
		
	}
	
	public void check(int id,String name,String phone)
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
	public void edit(int id1,String name,String phone){
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
						System.out.println(""+"\n"+"\n"+" gonne to edit method");
						System.out.println("affter edit[]"+id1+name+phone);
						System.out.println("befor edit[]"+field[0]+field[1]+field[2]);
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
					System.out.println("cc/remove/"+id+" "+tempId);
					if(id==tempId)
					{
						System.out.println("cc/remove/"+id+" "+tempId);
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
			System.out.println("edit/Exception "+e+" "+"/n"+"/n");
		}
		System.out.println("delete is ="+contactData.delete());
		try{
			System.out.println("cc/remove/2loop st/ "+" "+"/n"+"/n");

			for(ArrayList<String>rowData:contactsFile){
				System.out.println(rowData.get(0)+rowData.get(1)+rowData.get(2));
				int tempId=Integer.parseInt(rowData.get(0));
				save(tempId,rowData.get(1),rowData.get(2));
				
			}
		}
		catch(Exception ep){
				System.out.println("cc/remove/2st/ "+ep+" "+"/n"+"/n");
			}
		
		
		
	}
}