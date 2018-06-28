package com.lxisoft.contacts.utility;

import java.sql.*;

public class DatabaseUtils{

	private String url, username, password;
	private Connection connection;
	
	//SINGLETON
	private static DatabaseUtils instance;
	private DatabaseUtils(){}
	public static DatabaseUtils getInstance(){
		if(instance==null){
			instance=new DatabaseUtils();
		}
		return instance;
	}     
	
	//CONFIFIGURE
	public void configure(String url, String username, String password){
		System.out.println("configure_DatabaseUtils");
		this.url = url;
		this.username = username;
		this.password = password;
	}

	//GET CONNECTION
	public Connection getConnection() throws SQLException{
		System.out.println("connect_DatabaseUtils");
		if(connection == null || connection.isClosed()){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	//DISCONNECT
	public void disconnect() throws SQLException{
		System.out.println("disconnect_DatabaseUtils");
		if(connection != null){	// CHECK IF NEEDED: && connection.isClosed()
			connection.close();	 
		}
	}
	
}