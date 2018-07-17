package com.lxisoft.controller;

import java.util.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.NamingException;
import javax.naming.InitialContext;



public class Database
{
    
	private DataSource dataSource;

    public Database(String jndiname) {
    try {
        dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + jndiname);
    } catch (NamingException e) {
        // Handle error that it's not configured in JNDI.
        throw new IllegalStateException(jndiname + " is missing in JNDI!", e);
    }
   }

   
		
    public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
    
   }

}