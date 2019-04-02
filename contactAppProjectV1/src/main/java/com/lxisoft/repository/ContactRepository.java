package com.lxisoft.repository;
import com.lxisoft.model.Contact;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ContactRepository {

		PreparedStatement stmt=null;
		Connection con=null;
		Statement stm=null;
		//DataSource ds = DataSourceRepository.getMySQLDataSource();

		
		//public void connect(){
		//	try{
		//		con = ds.getConnection();
		//	}
		
		//catch(SQLException se){se.printStackTrace();}
		//}
		public void connect(){
			try{
			//register JDBC driver		
			Class.forName("com.mysql.jdbc.Driver");  
			//open a connection		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb","root","root");	
			}
			catch(ClassNotFoundException c){c.printStackTrace();}
			catch(SQLException se){se.printStackTrace();}
		}
		
		public  String insertContact(Contact c) throws SQLException {
			String result="";
			connect();

	//execute a query
			String query = "INSERT INTO contacts (first_name,last_name,phone,number,email) VALUES (? ,? ,?, ?, ?)";
			stmt=con.prepareStatement(query); 
			stmt.setString(1,c.getFirstName());
			stmt.setString(2,c.getLastName());
			stmt.setString(3,c.getPhone());
			stmt.setString(4,c.getNumber());
			stmt.setString(5,c.getEmail());
			stmt.executeUpdate(); 
			result="Save";
			stmt.close();
			con.close();
			
			return result;
			}  
			
		public  ArrayList<Contact> getContactList() throws SQLException {
			
			ArrayList<Contact> list = new ArrayList<Contact>();
			connect();
			stm=con.createStatement();
			String sql="SELECT * FROM contacts";
			ResultSet rs=stm.executeQuery(sql);

			while(rs.next()){
				int id=rs.getInt("id");
				String first_Name = rs.getString("first_name");
				String last_Name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String number= rs.getString("number");
				String email = rs.getString("email");
				Contact contact = new Contact(id,first_Name,last_Name,phone,number,email);
				list.add(contact);
			}
			rs.close();
			stm.close();
			con.close();
			return list;
			}
		public String delete(String name)throws SQLException{
			connect();
			String result="";
			stm=con.createStatement();
			String sql="DELETE FROM contacts WHERE id='"+name+"'";
			int result1=stm.executeUpdate(sql);

			result="delete";
			stm.close();
			con.close();
			return result;

		}
		public String update(String uFirstName,String uLastName,String uPhone,String uNumber,String uEmail) throws SQLException{
			//System.out.println(uFirstName+" "+uLastName+" "+" "+uPhone+" "+" "+uNumber+" "+" "+uEmail+" ");
			ArrayList<Contact> list=new ArrayList<Contact>();
			list=getContactList();
			connect();
			String result="";
			String sql="";
			stm=con.createStatement();
			for(Contact contact:list){
				if(uFirstName.equals(contact.getFirstName())&&uNumber!=(contact.getNumber())){
					sql="UPDATE contacts SET first_name='"+uFirstName+"',last_name='"+uLastName+"',phone='"+uPhone+"', number='"+uNumber+"',email='"+uEmail+"' WHERE number='"+contact.getNumber()+"'";
					result="update";
				}
				if((uFirstName!=(contact.getFirstName()))&&uNumber.equals(contact.getNumber())){
					sql="UPDATE contacts SET first_name='"+uFirstName+"',last_name='"+uLastName+"',phone='"+uPhone+"', number='"+uNumber+"',email='"+uEmail+"' WHERE first_name='"+contact.getFirstName()+"'";	
					result="update";}
			}
					stm.executeUpdate(sql);
					stm.close();
					con.close();
				return result;
		}
		public ArrayList<Contact> search(String name) throws SQLException{

			ArrayList<Contact> list=new ArrayList<Contact>();

			connect();
			String result="";
			stm=con.createStatement();
			String sql="SELECT * FROM  contacts WHERE first_name='"+name+"'";
			ResultSet rs=stm.executeQuery(sql);

			while(rs.next()){
				String first_Name = rs.getString("first_name");
				String last_Name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String number= rs.getString("number");
				String email = rs.getString("email");
				Contact contact = new Contact(first_Name,last_Name,phone,number,email);
				list.add(contact);
			}
			rs.close();
			stm.close();
			con.close();
			return list;
		}


		public ArrayList getDetail(String cId) throws SQLException {
			
			ArrayList list=new ArrayList();

			connect();
			String result="";
			stm=con.createStatement();
			String sql="SELECT * FROM  contacts WHERE first_Name='"+cId+"'";
			ResultSet rs=stm.executeQuery(sql);

			while(rs.next()){
				String first_Name = rs.getString("first_name");
				String last_Name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String number= rs.getString("number");
				String email = rs.getString("email");
				list.add(first_Name);
				list.add(last_Name);
				list.add(phone);
				list.add(number);
				list.add(email);
			}
			rs.close();
			stm.close();
			con.close();
			return list;
		}
				
}


