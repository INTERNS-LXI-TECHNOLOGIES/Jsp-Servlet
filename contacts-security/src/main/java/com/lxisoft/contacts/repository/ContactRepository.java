package com.lxisoft.contacts.repository;

import com.lxisoft.contacts.model.*;
import java.sql.*;
import java.util.*;
import com.lxisoft.contacts.utility.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

//Connect to MySQL database via JDBC: http://www.codejava.net/java-se/jdbc/connect-to-mysql-database-via-jdbc
//JDBC Tutorial on SQL Insert, Select, Update, and Delete Examples: http://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples

public class ContactRepository{
	
	private static final Logger LOGGER = LogManager.getLogger(ContactRepository.class.getName());
	private Connection connection;
	
	//CONNECT
	public void connect() throws SQLException{
		LOGGER.info("connect");
		connection = DatabaseUtils.getInstance().getConnection();
	}
	
	//DISCONNECT
	public void disconnect() throws SQLException{
		LOGGER.info("disconnect");
		DatabaseUtils.getInstance().disconnect();
	}
	
	//SAVE CONTACT
	public boolean save(Contact contact)throws SQLException{
		LOGGER.info("save");
		connect();
		String sql = "insert into contacts (username, name, phone) values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, contact.getUsername());
		preparedStatement.setString(2, contact.getName());
		preparedStatement.setInt(3, contact.getPhone());
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		
		return rowInserted;
	}
	
	//FIND CONTACT
	public Contact findOne(String username)throws SQLException{
		LOGGER.info("findOne");
		Contact contact = null;
		connect();
		String sql = "select * from contacts where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			String name = resultSet.getString("name");	//can also retrieve by column number(1 based) in db -> getString(2);
			int phone = resultSet.getInt("phone");
			contact = new Contact(name, phone);
		}
		resultSet.close();
		preparedStatement.close();
		disconnect();
		
		return contact;
	}
	
	//FIND ALL CONTACTS
	public List<Contact> findAll()throws SQLException{
		LOGGER.info("findAll");
		List<Contact> contactList = new ArrayList<Contact>();
		connect();
		String sql = "select * from contacts";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			String name = resultSet.getString("name");	
			int phone = resultSet.getInt("phone");
			contactList.add(new Contact(name, phone));
		}
		resultSet.close();
		statement.close();
		disconnect();
		
		return contactList;
	}
	
	//UPDATE CONTACT
	public boolean update(Contact updatedContact)throws SQLException{
		LOGGER.info("update");
		connect();
		String sql = "update contacts set name = ?, phone = ? where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, updatedContact.getName());
		preparedStatement.setInt(2, updatedContact.getPhone());
		preparedStatement.setString(3, updatedContact.getUsername());
		boolean rowUpdated = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		
		return rowUpdated;
	}
	
	//DELETE CONTACT
	public boolean delete(String username)throws SQLException{
		LOGGER.info("delete");
		connect();
		String sql = "delete from contacts where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		
		return rowDeleted;
	}
	
	
}