package com.lxisoft.controller;
import com.lxisoft.model.Contact;
import java.util.Set;
import java.util.TreeSet;
import java.sql.ResultSet;
import com.lxisoft.repository.Dbcon;

/**
*The FileService program implements creating file and saving contacts to the file
*and also implement the retrieving data from the file created
@version 1.2
@author ruhail
@since 2018-06-14
*/

public class DBService
{
	static Dbcon con=new Dbcon();
	/**
	*writeToFile method create a directory and a file in that directory.
	*local variable s contain directory path and file name is contacts.csv
	*contacts are added to file using BufferedWriter wrapped with FileWriter class
	*writing data to file is by using contact getters
	*/
	public int insertToDB(Contact cont)
	{
		int status=0;
		try
		{
			String insertQuery="insert into table_contacts(name,place,phoneNumber,email) values('"+cont.getName()+"','"+cont.getPlace()+"','"+cont.getPhoneNumber()+"','"+cont.getEmail()+"')";
			status=con.manipulate(insertQuery);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public Set<Contact> selectFromDB()
	{
		Set<Contact> contact=new TreeSet<Contact>();
		ResultSet rs;
		try
		{
			String selectQuery="select * from table_contacts";
			rs=con.select(selectQuery);
			while(rs.next())
			{
				Contact c=new Contact();
				String name=rs.getString("name");
				String place=rs.getString("place");
				String phoneNumber=rs.getString("phoneNumber");
				String email=rs.getString("email");
				c.setName(name);
				c.setPlace(place);
				c.setPhoneNumber(phoneNumber);
				c.setEmail(email);
				contact.add(c);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return contact;
	}
	public int deleteFromDB(String nam)
	{
		int status=0;
		try
		{
			String deleteQuery="delete from table_contacts where name='"+nam+"'";
			status=con.manipulate(deleteQuery);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public int updateDB(Contact cont,String nam)
	{
		int status=0;
		try
		{
			String updateQuery="update table_contacts set name='"+cont.getName()+"',place='"+cont.getPlace()+"',phoneNumber='"+cont.getPhoneNumber()+"',email='"+cont.getEmail()+"' where name='"+nam+"'";
			status=con.manipulate(updateQuery);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public Set<Contact> searchFromDB(String search)
	{
		Set<Contact> contact=new TreeSet<Contact>();
		ResultSet rs;
		try
		{
			String searchQuery="select * from table_contacts where name like ?";
			rs=con.searchSelect(searchQuery,search);
			while(rs.next())
			{
				Contact c=new Contact();
				String name=rs.getString("name");
				String place=rs.getString("place");
				String phoneNumber=rs.getString("phoneNumber");
				String email=rs.getString("email");
				c.setName(name);
				c.setPlace(place);
				c.setPhoneNumber(phoneNumber);
				c.setEmail(email);
				contact.add(c);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return contact;
	}
}