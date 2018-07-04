package com.lxisoft.contacts.utility;

import java.sql.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DatabaseUtils{

	private static final Logger LOGGER = LogManager.getLogger(DatabaseUtils.class.getName());
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
		LOGGER.info("configure");
		this.url = url;
		this.username = username;
		this.password = password;
	}

	//GET CONNECTION
	public Connection getConnection() throws SQLException{
		LOGGER.info("connect");
		if(connection == null || connection.isClosed()){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	//DISCONNECT
	public void disconnect() throws SQLException{
		LOGGER.info("disconnect");
		if(connection != null){	// CHECK IF NEEDED: && connection.isClosed()
			connection.close();	 
		}
	}
	
}