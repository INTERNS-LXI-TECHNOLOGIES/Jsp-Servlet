package com.lxisoft.repository;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
public class Dbcon
{
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	int a;
	public Dbcon()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/contactdb","root","root");
		}
		catch(Exception ex)
		{
			
		}	
	}
	public int manipulate(String query)
	{
		try
		{
			ps=con.prepareStatement(query);
			a=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return a;
	}
	public ResultSet select(String query)
	{
		try
		{
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet searchSelect(String query,String sr)
	{
		try
		{
			ps=con.prepareStatement(query);
			ps.setString(1,sr);
			rs=ps.executeQuery();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
}