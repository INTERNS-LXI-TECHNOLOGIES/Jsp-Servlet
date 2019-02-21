package com.lxisoft.contactapp.repository;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import com.lxisoft.contactapp.model.Contact;
import java.io.IOException;
import java.util.ArrayList;

public class ContactRepo{
	
	
	File contactDetails=new File("D:/lxisoft.app/apache-tomcat-8.5.38/webapps/contactappv2/data/Contacts.txt");
	FileWriter fw=null;
	BufferedWriter bw=null;
	FileReader fr=null;
	BufferedReader br=null;
	ArrayList<Contact> contactList;
	Contact contact;
	public String addToFile(String name,String phone,String number,String email){
		
	try{
	fw=new FileWriter(contactDetails,true);
	bw=new BufferedWriter(fw);
	bw.write(name+","+phone+","+number+","+email);
	bw.newLine();
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();}
			catch(IOException e){
				e.printStackTrace();}
	}
	String save="save";
	return save;
	}
	
	public ArrayList<Contact> loadFile(){
		String line;
		
		try{	
		fr=new FileReader(contactDetails);
		br=new BufferedReader(fr);	
		while((line=br.readLine())!=null){
		String[] data = line.split(",");
		
		contact= new Contact(data[0],data[1],data[2],data[3]);}
		contactList= new ArrayList<Contact>();
		contactList.add(contact);
		}catch(IOException e){
			
			System.out.println("Error");}
		return contactList;			
	}
	
}