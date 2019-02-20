package com.lxisoft.contactapp.model;

public class Contact{
private String name;
private String phone;
private String number;
private String email;

	public Contact(String name,String phone,String number,String email){
		this.name=name;
		this.phone=phone;
		this.number=number;
		this.email=email;
	}

	/*public void setName(String name) {
        this.name = name;
    }*/
	public String getName() {
        return name;
    }

	/*public void setEmail(String email) { 
        this.email = email;
    }*/
	
	public String getEmail() {
        return email;
    }

	public String getPhone() {
        return phone;
    }

	/*public void setPhone(String phone) {
        this.phone = phone;
    }
	
	public void setNumber(String number) {
        this.number = number;
    }*/
	public String getNumber() {
        return number;
    }
	
	
	public String toString(){
	return name+" "+phone+" "+number+" "+email+" ";
	}
}