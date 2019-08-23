package com.lxisoft.Contact.model;
import java.util.*;
public class ContactModel
{

	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String mobNumber;
	private String email;

	
	public String getPhone()
	{
	return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMobNumber() {
		return mobNumber;
	}


	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String toString()
		{
		return firstName+" "+lastName+" "+phone+" "+mobNumber+" "+email+" ";
		}


		public void setId(int id) 
		{
			this.id=id;
			
		}
		public int getId()
		{
			return id;
		}



}