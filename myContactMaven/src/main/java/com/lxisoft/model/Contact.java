package com.lxisoft.model;
public class Contact  implements Comparable<Contact>
{
	private String name;
	private String place;
	private String phoneNumber;
	private String email;
	
	public boolean equals(Object o)
	{
		if(o instanceof Contact)
		{
			Contact c=(Contact)o;
			if(this.phoneNumber==c.phoneNumber&&this.email==c.email)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public int compareTo(Contact contact)
	{
		return (this.name).compareTo(contact.name);
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setPlace(String place)
	{
		this.place=place;
	}
	public String getPlace()
	{
		return this.place;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return this.email;
	}
}