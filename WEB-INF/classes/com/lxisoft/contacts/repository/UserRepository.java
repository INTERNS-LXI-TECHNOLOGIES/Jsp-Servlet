package com.lxisoft.contacts.repository;

import com.lxisoft.contacts.model.*;
import java.sql.*;
import com.lxisoft.contacts.utility.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserRepository{
	
	private static final Logger LOGGER = LogManager.getLogger(UserRepository.class.getName());
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
	
	//SAVE USER
	public boolean save(User user) throws SQLException{
		LOGGER.info("save");
		connect();
		String sql = "insert into users (username, password) values (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		disconnect();
		
		return rowInserted;
	}
	
	//FIND USER
	public User findOne(String username, String password) throws SQLException{
		LOGGER.info("findOne");
		User user = null;
		connect();
		String sql = "select * from users where username = ? and password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			int userId = resultSet.getInt("user_id");
			user = new User(userId);
		}
		resultSet.close();
		preparedStatement.close();
		disconnect();
		
		return user;
	}
	
}