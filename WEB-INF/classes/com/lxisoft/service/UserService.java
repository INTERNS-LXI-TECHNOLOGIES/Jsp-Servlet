package com.lxisoft.service;
import com.lxisoft.model.*;
import java.io.*;
import java.util.Scanner;

public class UserService{

	//CREAT USER
	public void create(User user){
		System.out.println("create_UserService");
		
		try{
			File file = new File("D:\\apache-tomcat-7.0.72\\webapps\\contact_version1\\files\\users.txt");
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
			pw.append(user.getId() + " " + user.getUsername() + " " + user.getPassword());
			pw.println();
			pw.flush();
			pw.close();	
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//READ USER
	public User read(User user){
		System.out.println("read_UserService");
		
		FileReader fr = null;
		String username="", password="";
		int id = 0;
		String data = "";
		try{
			File file = new File("D:\\apache-tomcat-7.0.72\\webapps\\contact_version1\\files\\users.txt");
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);			
			
			while( (data = br.readLine()) != null){
				Scanner scanner = new Scanner(data);
				id = scanner.nextInt();
				username = scanner.next(); 
				password = scanner.next();
				if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
					return new User(id, username, password);
				}
			}	
			return null;
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
		return null;
	}



}