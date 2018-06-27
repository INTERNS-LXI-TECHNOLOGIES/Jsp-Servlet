package com.lxisoft.contacts.repository;

import com.lxisoft.contacts.model.*;
import java.sql.*;
import java.util.*;

//Connect to MySQL database via JDBC: http://www.codejava.net/java-se/jdbc/connect-to-mysql-database-via-jdbc
//JDBC Tutorial on SQL Insert, Select, Update, and Delete Examples: http://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples

public class ContactRepository{
	
	private String url, username, password;
	private Connection connection;
	
	//CONSTRUCTOR
	public ContactRepository(String url, String username, String password){
		System.out.println("constructor_ContactRepository");
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	//CONNECT
	public void connect() throws SQLException{
		System.out.println("connect_ContactRepository");
		if(connection == null || connection.isClosed()){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, username, password);
		}
	}
	
	//DISCONNECT
	public void disconnect() throws SQLException{
		System.out.println("disconnect_ContactRepository");
		if(connection != null){	// CHECK IF NEEDED: && connection.isClosed()
			connection.close();	 
		}
	}
	
	//SAVE CONTACT
	public boolean save(Contact contact){
		System.out.println("save_ContactRepository");
		connect();
		String sql = "insert into contacts (user_id, name, phone) values (?, ?, )";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, contact.getUserId());
		preparedStatement.setString(2, contact.getName);
		preparedStatement.setInt(3, contact.getPhone());
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		return rowInserted;
	}
	
	//READ CONTACT
	public Contact findOne(int userId){
		System.out.println("findOne_ContactRepository");
		Contact contact = null;
		connect();
		String sql = "select * from contacts where user_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
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
	
	//READ ALL CONTACTS
	public List<Contact> findAll(){
		System.out.println("findAll_ContactRepository");
		List<Contact> contactList = new ArrayList<Contact>();
		connect();
		String sql = "select * from contacts";
		Statement statement = connection.createStatement(sql);
		ResultSet resultSet = statement.executeQuery();
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
	public boolean update(Contact updatedContact){
		System.out.println("update_ContactRepository");
		connect();
		String sql = "update contacts set name = ?, phone = ? where user_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, updatedContact.getName);
		preparedStatement.setInt(2, updatedContact.getPhone());
		preparedStatement.setInt(3, updatedContact.getUserId());
		boolean rowUpdated = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		
		return rowUpdated;
	}
	
	//DELETE CONTACT
	public boolean delete(int userId){
		System.out.println("delete_ContactRepository");
		connect();
		String sql = "delete from contacts where user_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		
		return rowDeleted;
	}
	
	
}