package com.lxisoft.controller;
import com.lxisoft.controller.ContactController;
import com.lxisoft.controller.FileService;
import com.lxisoft.model.Contact;
import java.util.*;
public class TDD
{
	public static void main(String[] args)
	{
		ContactController c=new ContactController();
		c.addContact("ruhail","plae","jhh","hdh");
		Set<Contact> con=c.viewContact();
		Contact conta=null;
		for(Contact co:con)
		{
			System.out.println(co.getName()+"  "+co.getPlace()+"  "+co.getPhoneNumber()+"  "+co.getEmail());
			conta=co;
		}
		c.deleteContact(conta);
		Set<Contact> cont=c.viewContact();
		for(Contact co:cont)
		{
			System.out.println(co.getName()+"  "+co.getPlace()+"  "+co.getPhoneNumber()+"  "+co.getEmail());
		}
	}
}