package com.lxisoft.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import com.lxisoft.model.Contact;

public class ContactRepository{

	File file=new File("D:/Project/tomcat/webapps/contact-appv2/data/ContactList.txt");
	FileWriter fw=null;
	BufferedWriter bw=null;

	public void addToFile(Contact contact){
		try{
			fw=new FileWriter(file,true);
			bw=new BufferedWriter(fw);
			bw.write(contact.getName()+";");
			bw.write(contact.getPhno()+"\n");
			bw.close();
			fw.close();
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}
}