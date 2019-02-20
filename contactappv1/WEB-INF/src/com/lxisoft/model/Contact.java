package com.lxisoft.model;

public class Contact{
	private String name;
	private String phNumber;
	private String email;
	private String userPhone;
	public Contact(String name,String phNumber){
		this.name=name;
		this.phNumber=phNumber;
	}
	
	public String getName() {
        return name;
    }

	public void setEmail(String email) {
        this.email = email;
    }
	
	public String getUserPhone() {
        return userPhone;
    }

	public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
	
	public String getEmail() {
        return email;
    }

	public String getNumber() {
        return phNumber;
    }
public String toString(){
	return name+" "+phNumber+" ";
}
}