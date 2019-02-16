package com.lxisoft.model;
public class Contact{

	private String name;
	private String phno;

	public Contact(String name,String phno){

		this.name=name;
		this.phno=phno;
	}
	public String getName(){

		return name;
	}
	public String getPhno(){

		return phno;
	}
}