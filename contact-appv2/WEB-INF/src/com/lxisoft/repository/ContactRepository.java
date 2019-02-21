package com.lxisoft.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import com.lxisoft.model.Contact;

public class ContactRepository{

	File file=new File("D:/Project/tomcat/webapps/contact-appv2/data/ContactList.txt");
	FileWriter fw=null;
	BufferedWriter bw=null;
	FileReader fr=null;
	BufferedReader br=null;
	
	public String addToFile(Contact contact){
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
		String save="save";
		return save;
	}
	public ArrayList<Contact> getFromFile(){
		ArrayList<Contact> conList=null;
		try{
			conList=new ArrayList<Contact>();
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(";");
				Contact con=new Contact(data[0],data[1]);
				conList.add(con);
			}

		}
		catch(Exception e){

			e.printStackTrace();
		}
		return conList;

	}
}