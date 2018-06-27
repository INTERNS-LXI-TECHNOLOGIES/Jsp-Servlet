package com.lxisoft.contacts.model;

public class Contact{

	private int userId;
	private int contactId;
	private String name;
	private int phone;

	public Contact(String name, int phone){
		this.name = name;
		this.phone = phone;
	}

	public Contact(int userId, int contactId, String name, int phone){
		this.userId = userId;
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
	}

	public int getUserId(){
		return userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getContactId(){
		return contactId;
	}
	
	public void setContactId(contactId){
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


//login - session, readContact, updateContact, deleteContact
