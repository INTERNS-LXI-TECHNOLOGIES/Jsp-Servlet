package com.lxisoft.controller;
import java.util.*;
import com.lxisoft.model.Contact;

public class SortByFirstName implements Comparator<Contact>
{
  public int compare(Contact ct1,Contact ct2)
  {
	  return ct1.getFirstName().compareTo(ct2.getFirstName());
  }
}