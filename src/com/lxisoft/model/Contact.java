package com.lxisoft.model;
import java.sql.*;
public class Contact{
	//public int id;
    private String name;
	private String phone;
	
	
	public Contact(ResultSet resultSet) throws SQLException{
		//this.id=id;
		this.name=name;
		this.phone=phone;
		
		
		
	}
	/*public Contact(String name,String phone){
		//this.id=id;
		this.name=name;
		this.phone=phone;
		
		
		
	}*/
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	} 
	public void setPhoneNumber(String Phone){
		this.phone=phone;
	}
	public String getPhoneNumber(){
		return phone;
	}
	
	
	
	
}