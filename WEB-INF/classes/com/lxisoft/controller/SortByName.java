package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;

public class SortByName implements Comparator<Contact>
{
	public int compare(Contact contact1,Contact contact2)
	{
		return contact1.getName().compareTo(contact2.getName());
	}
	
}