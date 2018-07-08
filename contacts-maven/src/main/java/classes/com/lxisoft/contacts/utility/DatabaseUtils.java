package com.lxisoft.contacts.utility;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
//import javax.annotation.Resource;

public class DatabaseUtils{

	private static final Logger LOGGER = LogManager.getLogger(DatabaseUtils.class.getName());
	private Connection connection;
	//@Resource(name="jdbc/contacts-maven")
	private DataSource dataSource;
	
	//SINGLETON
	private static DatabaseUtils instance;
	private DatabaseUtils(){}
	public static DatabaseUtils getInstance(){
		if(instance==null){
			instance=new DatabaseUtils();
		}
		return instance;
	}     

	//GET CONNECTION
	public Connection getConnection() throws SQLException{
		LOGGER.info("connect");
		if(connection == null || connection.isClosed()){
			try {
				//Alternative: annotate 'private DataSource dataSource' with @Resource(name="jdbc/contacts-maven") 
				//import javax.annotation.Resource;
				Context context = new InitialContext();
				dataSource = (DataSource)context.lookup("java:comp/env/jdbc/contacts-maven");
			} catch (NamingException e) {	//NamingException is the superclass of all exceptions thrown by operations in the Context and DirContext interfaces.
				e.printStackTrace();
			}
			
			//Use DataSource instead of DriverManager for scalability since connections are now created in a file managed by server rather than inside a class.
			connection = dataSource.getConnection();
		}
		return connection;
	}
	
	//DISCONNECT
	public void disconnect() throws SQLException{
		LOGGER.info("disconnect");
		if(connection != null){	
			connection.close();	 
		}
	}
	
}