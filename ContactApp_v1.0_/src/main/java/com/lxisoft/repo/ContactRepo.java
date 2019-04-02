package com.lxisoft.repo;

import java.sql.*;

import java.util.ArrayList;

import com.lxisoft.model.Contact;
public class ContactRepo {

public void  createContact(){
        
        try{  
            
           Class.forName("com.mysql.jdbc.Driver");  
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
        
        }catch(Exception e){ System.out.println(e);}
        
      
    }  
public boolean checkLogin(String uname,String pass) {
	Connection con;
	String user = null;
	String pass1 = null;
	try{  
        
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
     
     
     
	String SQL = "select * from login where username=\"" + uname + "\"";

	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(SQL);
	while(rs.next()) {
		user=rs.getString("username");
		pass1=rs.getString("password");
	}
	

	if(user.equals(uname)&&pass.equals(pass1)) {
		
		return true;
		
	}   
}catch(Exception e){ System.out.println(e);}
	
	return false;
}
public boolean contactDis(String name,String no,String mail) {
String name=null;
String no=null;
String mail=null;
	Connection con;
	try{  
        
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
     
     
	Contact contact = new Contact();
	
	String SQL = "select * from contact where name="+contact.getName()+"number="+contact.getMobileNo()+"email="+contact.getEmail();
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(SQL);
	while(rs.next()) {
		name = rs.getString("name");
		no= rs.getString("number");
		mail=rs.getString("email");
	}
	if(name.equals(name)&&no.equals(no)&&mail.equals(name)) {
		System.out.println("gghj");
		return true;
	}
}catch(Exception e){ System.out.println(e);}	
}
}
