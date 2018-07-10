package com.lxisoft.model;
import java.sql.*;
public class Contact{
	public int id;
    public  String name;
	private String phoneNumber;
	private String place;
	private String emailId;
	
	public Contact(String name, String phoneNumber, String place, String emailId){
		
		setName(name);
		setPhoneNumber(phoneNumber);
		setPlace(place);
		setEmailId(emailId);
		
		
	}
	public Contact(ResultSet resultSet) throws SQLException{
		//this.id=id;
		this.name= resultSet.getString("name");
        this.phoneNumber = resultSet.getString("phoneNumber");
        this.place = resultSet.getString("place");
        this.emailId = resultSet.getString("emailId");
		
		
		
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	} 
	public void setPhoneNumber(String PhoneNumber){
		this.phoneNumber=phoneNumber;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setEmailId(String emailId){
		this.emailId=emailId;
	}
	public String getEmailId(){
		return emailId;
	}
	
	
	

}