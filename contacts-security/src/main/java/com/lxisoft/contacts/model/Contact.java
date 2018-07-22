package com.lxisoft.contacts.model;

public class Contact{

	private String username;
	private int contactId;
	private String name;
	private int phone;

	public Contact(String name, int phone){
		this.name = name;
		this.phone = phone;
	}

	public Contact(String username, String name, int phone){
		this.username = username;
		this.name = name;
		this.phone = phone;
	}
	
	public Contact(String username, int contactId, String name, int phone){
		this.username = username;
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
	}

	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public int getContactId(){
		return contactId;
	}
	
	public void setContactId(int contactId){
		this.contactId = contactId;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getPhone(){
		return phone;
	}
	public void setPhone(int phone){
		this.phone = phone;
	}
	
}
