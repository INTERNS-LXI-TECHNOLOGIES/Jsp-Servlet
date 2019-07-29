package com.lxisoft.contact;
import java.util.logging.*;
/**
*This class is used as a model class for Contact
*
*@author AryaVineesh
*
*@version 1.0
*
*Date Modified:25/07/2019
*/
public class Contact
{
	public Contact()
	{
		log.setLevel(Level.WARNING);
	}
	/**
	*Reference Logger class to get log messages
	*/
	private static final Logger log=Logger.getLogger(Contact.class.getName());
	
	/**
	*This is the firstName of the person
	*/
	private String firstName;
	
	/**
	*This is the lastName of the person
	*/
	private String lastName;
	
	/**
	*This is the workplace of the person
	*/
	private String workPlace;
	
	/**
	*This is the phone number of the person
	*/
	private String phoneNumber;
	
	
	/**
	*This method is used to set the firstName of the person
	*
	*@param firstName - the firstName to be set
	*
	*/
	public void setFirstName(String firstName)
	{
		log.info("Contact class............setFirstName...........Start");
		this.firstName=firstName;
		log.info("Contact class............setFirstName...........end");
	}
	
	/**
	*This method will return the firstName of the person
	*
	*@return firstName 
	*
	*/
	public String getFirstName()
	{
		log.info("Contact class............getFirstName...........Start/end");
		return firstName;
	}
	
	/**
	*This method is used to set the lastName of the person
	*
	*@param lastName - the lastName to be set
	*
	*/
	public void setLastName(String lastName)
	{
		log.info("Contact class............setLastName...........Start");
		this.lastName=lastName;
		log.info("Contact class............setLastName...........end");
	}
	
	/**
	*This method will return the lastName of the person
	*
	*@return lastName 
	*
	*/
	public String getLastName()
	{
		log.info("Contact class............getLastName...........Start/end");
		return lastName;
	}
	
	/**
	*This method is used to set the workPlace of the person
	*
	*@param workPlace - the workPlace to be set
	*
	*/
	public void setWorkPlace(String workPlace)
	{
		log.info("Contact class............setWorkPlace...........Start");
		this.workPlace=workPlace;
		log.info("Contact class............setWorkPlace...........end");
	}
	
	/**
	*This method will return the workPlace of the person
	*
	*@return workPlace 
	*
	*/
	public String getWorkPlace()
	{
		log.info("Contact class............getWorkPlace...........start/end");
		return workPlace;
	}
	
	/**
	*This method is used to set the phoneNumber of the person
	*
	*@param phoneNumber - the phoneNumber to be set
	*
	*/
	public void setPhoneNumber(String phoneNumber)
	{
		log.info("Contact class............setPhoneNumber...........start");
		this.phoneNumber=phoneNumber;
		log.info("Contact class............setPhoneNumber...........end");
	}
	
	/**
	*This method will return the phoneNumber of the person
	*
	*@return phoneNumber 
	*
	*/
	public String getPhoneNumber()
	{
		log.info("Contact class............getPhoneNumber...........start/end");
		return phoneNumber;
	}
	
	
}