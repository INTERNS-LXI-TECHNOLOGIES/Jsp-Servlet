package com.lxisoft;
import com.lxisoft.model.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import junit.framework.TestCase;

public class ContactTest extends TestCase{
	
	private Contact contact;
	
	public void setUp() throws Exception{
		contact=new Contact();
		contact.setName("ruhail");
		contact.setPlace("perambra");
		contact.setPhoneNumber("8086990809");
		contact.setEmail("ruhailfarhath@gmail.com");
	}
	
	public void testName(){
		
		String name1=contact.getName();
		assertEquals(name1,"ruhail");
			
	}
	public void testPlace(){
		
		String place1=contact.getPlace();
		assertEquals(place1,"perambra");	
	}
	public void testPhoneNumber(){
		String phone1=contact.getPhoneNumber();
		assertEquals(phone1,"8086990809");
	}
	public void testEmail()
	{
		String email1=contact.getEmail();
		assertEquals(email1,"ruhailfarhath@gmail.com");
	}
	

}