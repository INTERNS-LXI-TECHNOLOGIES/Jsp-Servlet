package com.lxisoft.model;
public class Contact{
	public int id;
    private String name;
	private String phoneNumber;
	
	
	public Contact(int  id,String name, String phoneNumber){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		
		
		
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
	
	
	
	
}