package com.lxisoft.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import com.lxisoft.model.Contact;
import java.io.IOException;

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
	public String removeFromFile(String name){

		ArrayList<Contact> list=null;
		list=getFromFile();
		
		try{
			 fw=new FileWriter(file);
			 bw=new BufferedWriter(fw);
	     	 
	     	 
	     	 for(int i=0;i<list.size();i++){
	   
	      		if(name.equals(list.get(i).getName())){

	      			list.remove(i);
	   
	      		}
	      	//	System.out.println(list);
	      		bw.write(list.get(i).getName()+";");
	      		bw.write(list.get(i).getPhno()+"\n");

	   		 }
	   		 bw.close();
	   		 fw.close();
		}
		catch(Exception e){

			e.printStackTrace();
		}
		String delete="delete";
		return delete;
	}
	public ArrayList<String> searchFromFile(String name){

		ArrayList<Contact> list=null;
		list=getFromFile();
		ArrayList<String> list1=new ArrayList<String>();
		String phno="";
		String nam="";
		for(int i=0;i<list.size();i++){
			if(name.equals(list.get(i).getName())){

				nam=list.get(i).getName();
				phno=list.get(i).getPhno();
				list1.add(nam);
				list1.add(phno);
			}
		}
		return list1;
	}
	public String editFromFile(String upName,String upPhno){

		ArrayList<Contact> list=null;
		list=getFromFile();
		try{
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
	     	 
				for(int i=0;i<list.size();i++){
					if((upName.equals(list.get(i).getName()))||(upPhno.equals(list.get(i).getPhno()))){

						Contact contact=new Contact(upName,upPhno);
						list.set(i,contact);
				}
	      		bw.write(list.get(i).getName()+";");
	      		bw.write(list.get(i).getPhno()+"\n");

	   		 }
	   		 bw.close();
	   		 fw.close();
	   		}
		catch(Exception e){

			e.printStackTrace();
		}
		String update="update";
		return update;
			

	}
}