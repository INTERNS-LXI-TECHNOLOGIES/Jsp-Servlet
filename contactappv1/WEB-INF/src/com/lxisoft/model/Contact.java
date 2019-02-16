package com.lxisoft.model;

public class Contact{
	private String name;
	private String phNumber;
	private String email;
	
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