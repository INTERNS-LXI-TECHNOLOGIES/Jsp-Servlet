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
}
