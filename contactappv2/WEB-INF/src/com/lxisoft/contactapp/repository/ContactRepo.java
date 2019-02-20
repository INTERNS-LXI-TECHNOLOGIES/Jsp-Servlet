package com.lxisoft.contactapp.repository;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import com.lxisoft.contactapp.model.Contact;
import java.io.IOException;

public class ContactRepo{
	
	
	File contactDetails=new File("D:/lxisoft.app/apache-tomcat-8.5.38/webapps/contactappv2/data/Contacts.txt");
	FileWriter fw=null;
	BufferedWriter bw=null;

	public void addToFile(String name,String phone,String number,String email){
		
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
	}
	
}