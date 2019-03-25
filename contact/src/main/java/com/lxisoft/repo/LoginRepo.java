package com.lxisoft.repo;

import java.sql.*;

public class LoginRepo {
	public String getUser(String name) throws SQLException, ClassNotFoundException { 
		 
		String password = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/contactuser","root","root");

		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from user where username = '"+name+"'");
		while(r.next()){
			password = r.getString("password");
		}
		return password;
	}
	public boolean setUser(String username,String password) throws ClassNotFoundException, SQLException {
		int x = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/contactuser","root","root");
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from user");
		while(r.next()){
			String usernames = r.getString("username");
			if(usernames.equals(username)) {
				x++;
			}
		}
		if(x==0) {
			PreparedStatement p = c.prepareStatement("insert into user(username,password) values(?,?)");
			p.setString(1,username);
			p.setString(2,password);
			p.execute();
			PreparedStatement pr = c.prepareStatement("create table "+username+"(id INT AUTO_INCREMENT,name VARCHAR(50),emailid VARCHAR(50),number VARCHAR(50),PRIMARY KEY(id))");
			pr.execute();
			return true;
		}
		else {
			return false;
		}
		
	}
}
