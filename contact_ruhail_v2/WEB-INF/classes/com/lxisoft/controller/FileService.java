package com.lxisoft.controller;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import com.lxisoft.model.Contact;
import java.util.Set;
import java.util.TreeSet;

/**
*The FileService program implements creating file and saving contacts to the file
*and also implement the retrieving data from the file created
@version 1.2
@author ruhail
@since 2018-06-14
*/

public class FileService
{
	static File fileDir;
	static File fileFile;
	static FileWriter fw;
	static PrintWriter pw;
	static BufferedReader br;
	static FileReader fr;
	/**
	*writeToFile method create a directory and a file in that directory.
	*local variable s contain directory path and file name is contacts.csv
	*contacts are added to file using BufferedWriter wrapped with FileWriter class
	*writing data to file is by using contact getters
	*/
	public void writeToFile(Contact con)
	{
		try
		{
			String s="E:/Apache_Tomcat/apache-tomcat-7.0.72/webapps/contact_ruhail_v2/data";
			fileDir=new File(s);
			if(fileDir.exists()==false)
			{
				fileDir.mkdir();
			}
			
			fileFile=new File(fileDir,"contacts.csv");
			if(fileFile.exists()==false)
			{
				fileFile.createNewFile();
			}
			//System.out.println(b);
			//System.out.println(c);
			fw=new FileWriter(fileFile,true);
			pw=new PrintWriter(fw);
			pw.print(con.getName()+","+con.getPlace()+","+con.getPhoneNumber()+","+con.getEmail()+"\n");
			pw.flush();
			pw.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("failed");	
		}
	}
	public Set<Contact> readFromFile()
	{
		Set<Contact> contact=new TreeSet<Contact>();
		try
		{
			String s1="E:/Apache_Tomcat/apache-tomcat-7.0.72/webapps/contact_ruhail_v2/data/contacts.csv";
			File f=new File(s1);
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			String data="";
			while((data=br.readLine())!=null)
			{
				String[] s=data.split(",");
				Contact c=new Contact();
				c.setName(s[0]);
				c.setPlace(s[1]);
				c.setPhoneNumber(s[2]);
				c.setEmail(s[3]);
				contact.add(c);
			}	
		}
		catch(Exception ex)
		{
			
		}
		return contact;
	}
	public void rewriteToFile(Set<Contact> contact)
	{
		try
		{
			String s1="E:/Apache_Tomcat/apache-tomcat-7.0.72/webapps/contact_ruhail_v2/data/contacts.csv";
			File f=new File(s1);
			FileWriter fw1=new FileWriter(f);
			PrintWriter pw1=new PrintWriter(fw1);
			pw1.print("");
			pw1.close();
			FileWriter fw2=new FileWriter(f,true);
			PrintWriter pw2=new PrintWriter(fw2);
			for(Contact con:contact)
			{
				pw2.print(con.getName()+","+con.getPlace()+","+con.getPhoneNumber()+","+con.getEmail()+"\n");
			}
			pw2.flush();
			pw2.close();
		}
		catch(Exception ex)
		{

		}
	}
	
}