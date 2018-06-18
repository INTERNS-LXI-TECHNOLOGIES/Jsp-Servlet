package com.lxisoft.service;
import com.lxisoft.model.Contact;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactService{

	//CREATE CONTACT
	public void create(Contact contact){
		System.out.println("create_ContactService");
		
		try{
			File file = new File("D:\\apache-tomcat-7.0.72\\webapps\\contact_version1\\files\\contacts.txt");
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
			pw.append(contact.getId() + " " + contact.getName() + " " + contact.getPhone());
			pw.println();
			pw.flush();
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//READ ALL CONTACTS
	public List<Contact> readAll(){
		System.out.println("readAll_ContactService");
		
		Contact contact;
		Boolean b = false;
		FileReader fr = null;
		int phone = 0, id = 0;
		String data = "", name = "";
		Scanner nameScanner, phoneScanner;
		List<Contact> contactList = new ArrayList<>();
		
		try{
			File file = new File("D:\\apache-tomcat-7.0.72\\webapps\\contact_version1\\files\\contacts.txt");
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while( (data = br.readLine()) != null){
				Scanner scanner = new Scanner(data);
				/* while(b = scanner.hasNext()) {
					if (scanner.hasNextInt()) {
						phone = scanner.nextInt(); 
					} else{
						name = scanner.next();
					} 	
				} */
				id = scanner.nextInt();
				name = scanner.next();
				phone = scanner.nextInt(); 
				System.out.println(id + " " + name + " " + phone);
				contact = new Contact(id, name, phone);
				contactList.add(contact);
			} 	
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fr != null){
				try{
					fr.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		return contactList;
	}
	
//public User readContact(){}
//public void update(){}
//public void delete(){}









}