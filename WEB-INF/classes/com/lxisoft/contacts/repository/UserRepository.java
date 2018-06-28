package com.lxisoft.contacts.repository;

import com.lxisoft.contacts.model.*;
import java.sql.*;
import com.lxisoft.contacts.utility.*;

public class UserRepository{
	
	private Connection connection;
	
	//CONNECT
	public void connect() throws SQLException{
		System.out.println("connect_UserRepository");
		connection = DatabaseUtils.getInstance().getConnection();
	}
	
	//DISCONNECT
	public void disconnect() throws SQLException{
		System.out.println("disconnect_UserRepository");
		DatabaseUtils.getInstance().disconnect();
	}
	
	//SAVE USER
	public boolean save(User user) throws SQLException{
		System.out.println("save_UserRepository");
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
		System.out.println("findOne_UserRepository");
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