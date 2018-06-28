package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
public class ContactController{
	
	
	public void dbInsertion(String name,String phone){
		
		
		try{
		
		/*String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);*/
        
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcontact", "root", "root");
			stmt = conn.createStatement();
			String sql = "insert into contacts(name,phone) values('"+name+"','"+phone+"')";
			stmt.executeUpdate(sql);
			conn.close();
		} catch(SQLException se) {
        se.printStackTrace();
    }catch(Exception e) {
        e.printStackTrace();
}
System.out.println(" "+name);
System.out.println(" "+phone);
}	

		
 
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}	
	
	}
	
	
	
		
	
}