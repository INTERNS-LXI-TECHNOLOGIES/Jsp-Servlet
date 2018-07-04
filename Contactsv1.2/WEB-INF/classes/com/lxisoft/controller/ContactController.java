package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
public class ContactController{
	
	
	private static Connection connection;
	
	
	public Connection connection(){
		return connection;
	}
	public void connection(Connection connection){
		this.connection=connection;
	}
	public  void save(int id,String name,String phone){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
			statement.execute("insert into contacts values("+id+",'"+name+"',"+phone+")");
			connection.close();
		}
		catch(Exception e){
			
			System.out.println(e);
		}
	}
	public Contact search(String name){
		Contact contact=new Contact(0,"non","non");
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from contacts where name='"+name+"'");
			if(resultSet.next())
			{
				contact=new Contact(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
			connection.close();
		}
		catch(Exception e)
		{
			//System.out.println("cc//"+e);
			e.printStackTrace();
		}
		return contact;
	}

	public void check(int id,String name,String phone)
	{
		try{
				Class.forName("com.mysql.jdbc.Driver");  
				 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
				Statement statement=connection.createStatement();
				ResultSet resultSet=statement.executeQuery("select * from contacts where id="+id);
				System.out.println("cc/check/ rs="+resultSet);
				if(id==0){
					id=generateId();
					
					connection.close();
					System.out.println("\n"+" gonning to save method"+"\n");
					save(id,name,phone);	
				}
				else
				{
					
					System.out.println("\n"+" gonning to edit method"+"\n");
					edit(id,name,phone);
				}
			}
			catch(Exception e)
			{
				System.out.println("cc/check/catch");
				e.printStackTrace();
			}
	}
	
	public int generateId(){
		
		return (int)((Math.random()*7)+(Math.random()*9)-(Math.random()*3)%(Math.random()*5)+((Math.random()*9)*(Math.random()*9)));
		
		
	}  
	
	public void edit(int id,String name,String phone){//reding all data,storing and editing the data .deleteing old data file saveing all data into the file by calling save
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
		statement.execute("update  contacts set id="+id+",name='"+name+"',phone='"+phone+"' where id="+id);
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println("edit/Exception "+e);
		}
		
	}
	public void remove(int id){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
			statement.execute("delete from contacts where id="+id);
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println("edit/Exception "+e);
		}
		
	}
	public ArrayList<Contact> getContacts(){
		ArrayList<Contact>contacts=new ArrayList<Contact>();
		try
		{
				Class.forName("com.mysql.jdbc.Driver");  
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
				Statement statement=connection.createStatement();
				ResultSet resultSet=statement.executeQuery("select * from contacts");
				while(resultSet.next())
				{
					System.out.println(" cc/getContacts "+resultSet.getInt(1)+resultSet.getString(2)+resultSet.getString(3));
					contacts.add(new Contact(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
					
					
				}
				connection.close();
		}
		catch(Exception e)
		{
			
			System.out.println("cc/getContacts//"+e);
			
		}
		return contacts;
	}
	
}