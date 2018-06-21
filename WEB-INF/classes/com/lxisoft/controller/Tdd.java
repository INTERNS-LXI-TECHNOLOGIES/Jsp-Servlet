package com.lxisoft.controller;
import java.io.*;
import com.lxisoft.model.*;
import java.util.*;
public class Tdd
{
public static void main(String[] args)
{
/*NewContactController nc = new NewContactController();
nc.addContact("silpa","ertyuio","356","@gmail");
nc.addContact("prasad","qwesd","89076","@rtyyu");
nc.addContact("gopalakrishnan","india","345678","@sdfg");
Set<Contact> set = nc.contactDisplay();
System.out.println(set.size());
for(Contact sets:set)
{
	
	System.out.println("......"+sets);
}*/
System.out.println("hii");
ContactFile cf = new ContactFile();
cf.addData("silpa","phnj","5678","ert");
cf.addData("prasad","sdfg","34567","wertyui");
cf.addData("amrutha","sdfg","34567","wertyui");

Set<Contact> contactSet = cf.readData();
System.out.println("test");
 System.out.println(contactSet.size());
 for(Contact contact:contactSet)
 {
 System.out.println(contact.getFirstName());
 System.out.println(contact.getPlace());
 System.out.println(contact.getPhone_Number());
 System.out.println(contact.getEmail_Id());
 
 }
 cf.deleteData("silpa");
 /*Set<Contact> contactSe = cf.readData();
System.out.println("test");
 System.out.println(contactSe.size());
 for(Contact contact:contactSe)
 {
 System.out.println(contact.getFirstName());
 System.out.println(contact.getPlace());
 System.out.println(contact.getPhone_Number());
 System.out.println(contact.getEmail_Id());
 
 }*/
 


}
}