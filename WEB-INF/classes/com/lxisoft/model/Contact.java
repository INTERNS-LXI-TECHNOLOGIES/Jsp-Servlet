package com.lxisoft.model;
public class Contact{
	public int id;
	private String name;
	private String phoneNumber;
	private String place;
	private String emailId;
	
	public Contact(int id,String name, String phoneNumber, String place, String emailId){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.place=place;
		this.emailId=emailId;
		
		
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