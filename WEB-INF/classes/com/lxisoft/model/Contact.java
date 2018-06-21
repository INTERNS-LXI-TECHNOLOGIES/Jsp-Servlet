package com.lxisoft.model;

import java.util.*;
public class Contact implements Comparable<Contact>
{
	// private String id_No;
     private String firstName;
     private String place;
     private String phone_Number;
     private String email_Id;

     public Contact(String firstName,String place,String phone_Number,String email_Id)
	 {
		// this.id_No = id_No;
		 this.firstName = firstName;
		 this.place = place;
		 this.phone_Number = phone_Number;
		 this.email_Id  = email_Id;
	 }
	 
	 
	 
	 
	
    public String toString()
    {
	 return this.firstName;
    } 
	/*public void setId_No(String id_No)
	{
		this.id_No = id_No;
	}
	public String getId_No()
	{
		return id_No;
	}*/
	/*public boolean equals(Object o)
	{
		if((o instanceof Contact)&&((Contact)o).getFirstName()==this.firstName))
			
			{
				return true;
			}
		else 
			return false;
	}*/
	
    public void setFirstName(String firstName)
   {
	this.firstName = firstName;
   }
   public String getFirstName()
  {
   return firstName;
  }
   public void setPlace(String place)
  {
	this.place = place;
   }	
   public String getPlace()
  {
   return this.place;
  }
   public void setPhone_Number(String Phone_Number)
  {
	this.phone_Number = phone_Number;
   }
    public String getPhone_Number()
   {
     return this.phone_Number;
   }
   public void setEmail_Id(String email_Id)
   {
 	this.email_Id = email_Id;
   }
   public String getEmail_Id()
   {
    return this.email_Id;
   } 
    public int compareTo(Contact contact)
    {
	  return this.firstName.compareTo(contact.getFirstName());
     }
}