package com.lxisoft.contact.repositoryimpl;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.lxisoft.contact.model.ContactModel;
import java.sql.DriverManager;
public class RepositoryImpl
{
	PreparedStatement ps;
	Connection con;
	public RepositoryImpl(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
		}catch(Exception e){
			System.out.println("connection not created");
			e.printStackTrace();
		}
	}
	
    public String add(String name,String number)
	{
		int status=0;
		  try
		   {
		     System.out.println("qqqqq"+name+"kkkkk"+number);
			  
              
              
             String insertQuery="insert into contact(name,number) values(?,?)";
             ps=con.prepareStatement(insertQuery);
		     ps.setString(1,name);
		     ps.setString(2,number);
			 System.out.println("before executed");
			 int a=ps.executeUpdate();
			System.out.println("inserted :"+a);
           }
		   catch(Exception e)
		   { 
		   System.out.println(e);
				return "failed";
		   } 
		return "success";		   
    }
   public ArrayList<ContactModel> read()
   {         System.out.println("...........");
             ArrayList<ContactModel> datas=new ArrayList<ContactModel>(); 
	         ResultSet rs;
			 try{
	         ps=con.prepareStatement("select * from contact");
             rs=ps.executeQuery();			 
             while(rs.next())
			 {	
              ContactModel cm=new ContactModel();
              cm.setName(rs.getString("name"));
			  cm.setNumber(rs.getString("number"));
			  datas.add(cm);
			  System.out.println("..........."+cm);
              System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			 return datas;
   }
   public void closer()
   {
	   try{
		    con.close();
	   }
	   catch(Exception a)
	   {
		   
	   }
   } 
   public void delete(String name)
   {
	 try{
	  String query="delete from contact where name=?";
	  ps=con.prepareStatement(query);
	  ps.setString(1,name);
	  ps.executeUpdate();
	   }
	 catch(Exception e){}
   } 
	public void updateName(String old,String newOne)
	{
		try{
				String updateQuery="UPDATE contact SET name = '"+newOne+"' where name= '"+old+"'";
				ps=con.prepareStatement(updateQuery);
				ps.executeUpdate();
		   }
		catch(Exception e)
		{}
    }
  	public void updateNumber(String old,String newOne)
	{
		try{
				String updateQuery="UPDATE contact SET number = '"+newOne+"' where number= '"+old+"'";
				ps=con.prepareStatement(updateQuery);
				ps.executeUpdate();
		   }
		catch(Exception e)
		{}
	}
}