package com.lxisoft.controller;
import com.lxisoft.model.Contact;
import java.util.Set;
import java.util.TreeSet;
import java.sql.ResultSet;
import javax.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.log4j.Logger;

/**
*The DBService class is used to handle database operatios
*instance variables are ds,ic,con,ps,rs;
*
@version 1.2
@author ruhail
@since 2018-07-04
*/

public class DBService
{
	DataSource ds;
	Context ic; 
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private final static Logger LOGGER = Logger.getLogger(ContactController.class.getName());
	int status;
	/**
	*insertToDB method inserts data to database.
	*creates database connection using data source.
	*execute query using sexecteUpadete mathod after preparing the query statement. 
	*/
	public int insertToDB(Contact cont)
	{
		try
		{
			ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:/comp/env/jdbc/contactdb");
			con=ds.getConnection();
			String insertQuery="insert into table_contacts(name,place,phoneNumber,email) values('"+cont.getName()+"','"+cont.getPlace()+"','"+cont.getPhoneNumber()+"','"+cont.getEmail()+"')";
			ps=con.prepareStatement(insertQuery);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	/**
	*selectFromDB method retrieve data from database.
	*creates database connection using data source.
	*execute query using execteQuery mathod after preparing the query statement. 
	*resultset data populate to contacts using setters and store in TreeSet.
	*/
	public Set<Contact> selectFromDB()
	{
		Set<Contact> contact=new TreeSet<Contact>();
		try
		{
			ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:/comp/env/jdbc/contactdb");
			con=ds.getConnection();
			String selectQuery="select * from table_contacts";
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery();
			con.close();
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
	/**
	*deleteFromDB method delete data from database.
	*creates database connection using data source.
	*execute query using execteUpdate mathod after preparing the query statement. 
	*/
	public int deleteFromDB(String nam)
	{
		try
		{
			ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:/comp/env/jdbc/contactdb");
			con=ds.getConnection();
			String deleteQuery="delete from table_contacts where name='"+nam+"'";
			ps=con.prepareStatement(deleteQuery);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	/**
	*updateDB method update data in database.
	*creates database connection using data source.
	*execute query using execteUpdate mathod after preparing the query statement. 
	*/
	public int updateDB(Contact cont,String nam)
	{
		try
		{
			ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:/comp/env/jdbc/contactdb");
			con=ds.getConnection();
			String updateQuery="update table_contacts set name='"+cont.getName()+"',place='"+cont.getPlace()+"',phoneNumber='"+cont.getPhoneNumber()+"',email='"+cont.getEmail()+"' where name='"+nam+"'";
			ps=con.prepareStatement(updateQuery);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	/**
	*searchFromDB method search and read data from database.
	*creates database connection using data source.
	*execute query using execteQuery mathod after preparing the query statement. 
	*/
	public Set<Contact> searchFromDB(String search)
	{
		LOGGER.info("------searching------");
		Set<Contact> contact=new TreeSet<Contact>();
		ResultSet rs;
		try
		{
			ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:/comp/env/jdbc/contactdb");
			con=ds.getConnection();
			String searchQuery="select * from table_contacts where name like '"+search+"%'";
			ps=con.prepareStatement(searchQuery);
			rs=ps.executeQuery(searchQuery);
			while(rs.next())
			{
				LOGGER.info("------search item found------");
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
			LOGGER.info("-----exception in searching-----");
			ex.printStackTrace();
		}
		LOGGER.info("------searching over------");
		return contact;
	}
}