package com.lxisoft.Contact.repositoryImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lxisoft.Contact.model.ContactModel;





public class RepositoryImpl
{
	Statement st,st1;
	ResultSet rs;
Connection con;
ArrayList<ContactModel> contacts=new ArrayList<ContactModel>();
public RepositoryImpl()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactapp","root","akhil1234");
	} catch (ClassNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
}

	public void addContact(ContactModel cm) 
	{
		// TODO Auto-generated method stub
		//System.out.println("AA:"+cm.getFirstName());
		try {
			
			String query = "INSERT INTO contact(id,firstName,lastName,phoneNumber,mobileNumber,email) values(?,?,?,?,?,?)";
			PreparedStatement prep = this.con.prepareStatement(query);
			prep.setInt(1, cm.getId());
			prep.setString(2, cm.getFirstName());
			prep.setString(3,cm.getLastName());
			prep.setString(4,cm.getPhone());
			prep.setString(5,cm.getMobNumber());
			prep.setString(6,cm.getEmail());
			boolean status = prep.execute();
			
			if(status)
			{
				System.out.println("Contact Added");
			}
			
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<ContactModel> viewAllContact()
	{
		
		try {
			st=con.createStatement();

		rs=st.executeQuery("select * from Contact");
		while(rs.next()) 
		{
			ContactModel contC=new ContactModel();
			contC.setId(rs.getInt(1));
			contC.setFirstName(rs.getString(2));
			contC.setLastName(rs.getString(3));
			contC.setPhone(rs.getString(4));
			contC.setMobNumber(rs.getString(5));
			contC.setEmail(rs.getString(6));
			//System.out.println("&^"+rs.getString(6));
			contacts.add(contC);
		}
		
		for(ContactModel tmp: contacts) 
		{
			System.out.println(tmp);
		}
		
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contacts;
	}
	public void close()
	{
		try {
			con.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateContact(String d,String data,String data1){
		try{
			System.out.println(data+" "+data1);
			st=con.createStatement();
			rs=st.executeQuery("select id from Contact where "+d+"='"+data+"'");
			if(rs.next()){
				String query = "update Contact set "+d+" = '"+data1+"' where "+d+" = '"+data+"'";
             	PreparedStatement preparedStmt = con.prepareStatement(query);
      			preparedStmt.executeUpdate();
			}
			else
			{}
		
		}
		catch(Exception e){}
	}

	public boolean check(String id) throws SQLException
	{
	st=con.createStatement();	
	rs=st.executeQuery("select * from Contact where id="+id);
		while(rs.next())
		{
			return true;
		}
		return false;
		
	}
	public void deleteContact( int id)
	{
		try
		{
			PreparedStatement ps;
			String sql="DELETE FROM Contact WHERE id="+id+"";
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}
		catch(SQLException es)
		{
			es.printStackTrace();
		}
	}

	public boolean checkDelete(String id) throws SQLException
	{
	st=con.createStatement();	
	rs=st.executeQuery("select * from Contact where id="+id);
		while(rs.next())
		{
			return true;
		}
		return false;
		
	}
	

}
