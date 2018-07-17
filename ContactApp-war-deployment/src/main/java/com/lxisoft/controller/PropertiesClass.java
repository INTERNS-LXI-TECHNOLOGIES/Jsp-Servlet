package com.lxisoft.controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesClass
{

   public static void main(String args[])
  {
 
  ResourceBundle myBundle = ResourceBundle.getBundle("MyLabels");
  Locale.setDefault(new Locale("ml","IN"));
  myBundle = ResourceBundle.getBundle("MyLabels");
  System.out.println("iam coming.. in malayalam"+myBundle.getString("coming"));
  
  }
  
  public static String getName()
  {
	  return "silpa";
  }
  
  
  
}