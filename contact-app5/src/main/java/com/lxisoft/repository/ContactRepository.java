package com.lxisoft.repository;


import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.lxisoft.model.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ContactRepository{

	static Logger LOGGER=Logger.getLogger(ContactRepository.class.getName());
	Connection connection=null;
	Statement stmt=null;
	
	String db_url="jdbc:mysql://localhost:3306/CONTACT";
	String user="root";
	String pass="root";

	public void connect() throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e){
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		connection=DriverManager.getConnection(db_url,user,pass);
		LOGGER.info(">Database connecting");
	}
	public String addToDatabase(Contact contact) throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		String result="";
		connect();
			try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			stmt=connection.createStatement();
			String sql="INSERT INTO CONTACT_DETAILS (Name,Phno)"+" VALUES ('"+contact.getName()+"','"+contact.getPhno()+"')";
			
	        boolean result1=stmt.executeUpdate(sql)>0;
	      	System.out.println(result1);
	        if(result1==true){
	
	        	result="insert";
	        }
	        LOGGER.info(">Contact Adding");
	         connection.close();
		}
			catch(Exception e){
				
				LOGGER.info(">Catching Exception ");
				e.printStackTrace();
			}
        return result;
		
	}
	public ArrayList<Contact> getFromDatabase() throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		ArrayList<Contact> list=new ArrayList<Contact>();
		connect();

		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			stmt=connection.createStatement();
			String sql="SELECT * FROM CONTACT_DETAILS";
			ResultSet rs=stmt.executeQuery(sql);

			while(rs.next()){

				String name=rs.getString("Name");
				String phno=rs.getString("Phno");
				Contact contact=new Contact(name,phno);
				list.add(contact);
			}
			LOGGER.info(">Contact Getting");
			rs.close();
			stmt.close();
			connection.close();
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return list;

	}
	public String deleteFromDatabase(String name) throws SQLException{

		connect();
		String result="";
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			stmt=connection.createStatement();
			String sql="DELETE FROM CONTACT_DETAILS WHERE Name='"+name+"'";
			stmt.executeUpdate(sql);
			LOGGER.info(">Contact Deleting");
			result="delete";
		
			connection.close();
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return result;

	}
	public String editData(String upName,String uname,String uphno) throws SQLException{

		LOGGER.info("entering the method");
		FileHandler fh;
		connect();
		String result="";
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
		
			stmt=connection.createStatement();
			
			String sql="UPDATE CONTACT_DETAILS SET Name='"+uname+"', Phno='"+uphno+"' WHERE Name='"+upName+"'";
			result="update";
				
			stmt.executeUpdate(sql);
			LOGGER.info(">Contact Updating");
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		connection.close();
		return result;
	}
	public ArrayList<String> searchData(String name) throws SQLException{
		LOGGER.info("entering the method");
		FileHandler fh;
		connect();
		ArrayList<String> list=new ArrayList<String>();
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
		
		stmt=connection.createStatement();
		String sql="SELECT * FROM CONTACT_DETAILS WHERE Name='"+name+"'";
		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next()){

			String name1=rs.getString("Name");
			String phno=rs.getString("Phno");
			list.add(name1);
			list.add(phno);
		}
		LOGGER.info(">Contact Searching");
		rs.close();
		stmt.close();
		connection.close();
		}
		catch(Exception e){
			
			LOGGER.info(">Catching Exception ");
			e.printStackTrace();
		}
		return list;

	}

	
}