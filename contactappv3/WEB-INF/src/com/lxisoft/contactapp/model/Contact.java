package com.lxisoft.contactapp.model;

public class Contact implements Comparable<Contact>{
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

	public String getName() {
        return name;
    }
	
	public String getEmail() {
        return email;
    }

	public String getPhone() {
        return phone;
    }
	
	public String getNumber() {
        return number;
    }
	
	public String toString(){
	return name+" "+phone+" "+number+" "+email+" ";
	}
	
	 public int compareTo(Contact contact){ 
        return name.compareTo(contact.getName()); 
    } 
	
	public boolean equals(Object o) {
		
		Contact contact=(Contact)o;
		if(o==null){
			return false;}
		if(this==o){
			return true;}
		if(name.equals(contact.name)){
			return true;}	
		else {
			return false;}
	}
}