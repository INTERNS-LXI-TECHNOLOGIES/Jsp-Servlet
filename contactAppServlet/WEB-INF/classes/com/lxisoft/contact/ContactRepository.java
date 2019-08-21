package com.lxisoft.contact;
import java.util.ArrayList;
import java.sql.*;
public class ContactRepository
{
	//static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	
	static final String DB_URL="jdbc:mysql://localhost/contact_db";
	static final String USER="root";
	static final String PASS="root";
	Connection con=null;
	Statement stmt=null;
	PreparedStatement ps=null;
	String sql;
	public  ContactRepository()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("connecting to database");
			
		con=DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("creating database");
		}
		catch(Exception e)
		{
			System.out.println("Not connecting to database");
			e.printStackTrace();
		}
	}
	public void createContact(Contact contact)throws Exception
	{
	try{
	sql="INSERT INTO contact(contact_name,contact_number) values(?,?)";
	ps=con.prepareStatement(sql);
	ps.setString(1,contact.getName());
	ps.setString(2,contact.getNum());
	int a=ps.executeUpdate();
	System.out.println("result  "+a);
	ps.close();
	con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public ArrayList<Contact> readContact()throws Exception
	{
		ArrayList<Contact> contacts=new ArrayList<Contact>();
		try{	
		stmt=con.createStatement();
		sql="select * from contact";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			Contact contact=new Contact();
			String contact_name=rs.getString("contact_name");
			String contact_number=rs.getString("contact_number");
			contact.setName(contact_name);
			contact.setNum(contact_number);
			//System.out.println("contact_name:"+contact_name);
			//System.out.println("contact_number:"+contact_number);
			contacts.add(contact);
		}
			
		// rs.close();
		// stmt.close();
		// con.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return contacts;
	}
	public int updateContact(String name,String editName)throws Exception
	{	
		int value=0;
		try
		{	
		sql="update contact  set contact_name='"+editName+"' WHERE contact_name='"+name+"'";
		ps=con.prepareStatement(sql);
		value=ps.executeUpdate();
		ps.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	public void deleteContact(String name)throws Exception
	{
		try
		{
		System.out.println(name);
		sql="DELETE FROM contact WHERE contact_name='"+name+"'";
		ps=con.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}