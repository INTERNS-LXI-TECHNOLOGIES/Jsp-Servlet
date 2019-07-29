package com.lxisoft.contact;
import java.util.*;
import java.util.logging.*;
import com.lxisoft.contact.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
/**
*This class is the repository class for Contact
*
*@author Arya Vineesh
*
*@version 1.0
*
*Date Modified:25/07/2019
*/
public class ContactRepository
{
	Connection con;
	PreparedStatement ps;
	
	/**
	*Reference Logger class to get log messages
	*/
	private static final Logger log=Logger.getLogger(ContactRepository.class.getName());
	
	public ContactRepository()
	{
		log.setLevel(Level.SEVERE);
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","root");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	}
	
	public int insertIntoDb(Contact contact)
	{
		int status=0;
		try
		{
			String insertQuery="insert into contact(firstName,lastName,workPlace,number) values(?,?,?,?)";
			ps=con.prepareStatement(insertQuery);
			ps.setString(1,contact.getFirstName());
			ps.setString(2,contact.getLastName());
			ps.setString(3,contact.getWorkPlace());
			ps.setString(4,contact.getPhoneNumber());
			status=ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}	
	
	public int updateDB(Contact contact,String oldName)
	{
		int status=0;
		try
		{
			
			String updateQuery="update contact set firstName=?,lastName=?,workPlace=?,number=? where firstName=?";
			ps=con.prepareStatement(updateQuery);
			
			ps.setString(1,contact.getFirstName());
			ps.setString(2,contact.getLastName());
			ps.setString(3,contact.getWorkPlace());
			ps.setString(4,contact.getPhoneNumber());
			ps.setString(5,oldName);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public int deleteFromDb(String name)
	{
		int status=0;
		try
		{
			String deleteQuery="delete from contact where firstName=?";
			ps=con.prepareStatement(deleteQuery);
			ps.setString(1,name);
			status=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<Contact> searchContactFromDb(String name)
	{
		
		ArrayList<Contact> contactList=new ArrayList<Contact>();
		Contact contact;
		ResultSet rs;
		try
		{
			String selectQuery="select * from contact where firstName=?";
			ps=con.prepareStatement(selectQuery);
			ps.setString(1,name);
			rs=ps.executeQuery();
			while(rs.next())
			{
				contact=new Contact();
				String firstName=rs.getString("firstName");
				String lastName=rs.getString("lastName");
				String workPlace=rs.getString("workPlace");
				String number=rs.getString("number");

				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setWorkPlace(workPlace);
				contact.setPhoneNumber(number);
				contactList.add(contact);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return contactList;
	}

	public ArrayList<Contact> selectContactFromDb()
	{
		
		ArrayList<Contact> contactList=new ArrayList<Contact>();
		Contact contact;
		ResultSet rs;
		try
		{
			String selectQuery="select * from contact";
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				contact=new Contact();
				String firstName=rs.getString("firstName");
				String lastName=rs.getString("lastName");
				String workPlace=rs.getString("workPlace");
				String number=rs.getString("number");

				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setWorkPlace(workPlace);
				contact.setPhoneNumber(number);
				contactList.add(contact);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return contactList;
	}
}