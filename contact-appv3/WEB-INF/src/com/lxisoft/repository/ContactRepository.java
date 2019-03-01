package com.lxisoft.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import com.lxisoft.model.Contact;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.lxisoft.model.Contact;

public class ContactRepository{

	
	Connection connection=null;
	Statement stmt=null;
	
	String db_url="jdbc:mysql://localhost:3306/CONTACT";
	String user="root";
	String pass="root";

	public void connect() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e){

			e.printStackTrace();
		}
		connection=DriverManager.getConnection(db_url,user,pass);

	}
	public String addToDatabase(Contact contact) throws SQLException{
		
		connect();
		stmt=connection.createStatement();
		String sql="INSERT INTO CONTACT_DETAILS (Name,Phno)"+" VALUES ('"+contact.getName()+"','"+contact.getPhno()+"')";
		String result="";
        boolean result1=stmt.executeUpdate(sql)>0;
      	System.out.println(result1);
        if(result1==true){

        	result="insert";
        }
         connection.close();
        return result;
		
	}
	public ArrayList<Contact> getFromDatabase() throws SQLException{

		ArrayList<Contact> list=new ArrayList<Contact>();
		connect();
		stmt=connection.createStatement();
		String sql="SELECT * FROM CONTACT_DETAILS";
		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next()){

			String name=rs.getString("Name");
			String phno=rs.getString("Phno");
			Contact contact=new Contact(name,phno);
			list.add(contact);
		}
		rs.close();
		stmt.close();
		connection.close();
		return list;

	}
	public String deleteFromDatabase(String name) throws SQLException{

		connect();
		String result="";
		stmt=connection.createStatement();
		String sql="DELETE FROM CONTACT_DETAILS WHERE Name='"+name+"'";
		int result1=stmt.executeUpdate(sql);
		
		result="delete";
		
		connection.close();
		return result;

	}
	public String editData(String uname,String uphno) throws SQLException{

		ArrayList<Contact> list=new ArrayList<Contact>();
		list=getFromDatabase();
		connect();
		String result="";
		String sql="";
		stmt=connection.createStatement();
		for(Contact contact:list){
			if(uname.equals(contact.getName())&&uphno!=(contact.getPhno())){
				
				sql="UPDATE CONTACT_DETAILS SET Name='"+uname+"', Phno='"+uphno+"' WHERE Phno='"+contact.getPhno()+"'";
				result="update";
			}
			else if((uname!=(contact.getName()))&&uphno.equals(contact.getPhno())){

				sql="UPDATE CONTACT_DETAILS SET Name='"+uname+"', Phno='"+uphno+"' WHERE Name='"+contact.getName()+"'";	
				result="update";
			}
		}
		int result1=stmt.executeUpdate(sql);
		connection.close();
		return result;
	}
	public ArrayList<String> searchData(String name) throws SQLException{

		ArrayList<String> list=new ArrayList<String>();

		connect();
		String result="";
		stmt=connection.createStatement();
		String sql="SELECT * FROM CONTACT_DETAILS WHERE Name='"+name+"'";
		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next()){

			String name1=rs.getString("Name");
			String phno=rs.getString("Phno");
			list.add(name1);
			list.add(phno);
		}
		rs.close();
		stmt.close();
		connection.close();
		return list;

	}

	
}