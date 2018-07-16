package com.lxisoft.controller;
import com.lxisoft.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.naming.*;

public class ContactServlet extends HttpServlet{
	static Logger LOGGER=Logger.getLogger(ContactServlet.class.getName());

	@Override
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
	LOGGER.info("entering the method");
	FileHandler fh;
	try{
		fh=new FileHandler("F:/apache-tomcat-7.0.72/webapps/contactSrvltlog/WEB-INF/classes/logWork");
		LOGGER.addHandler(fh);
		SimpleFormatter formatter=new SimpleFormatter();
		fh.setFormatter(formatter);
		//LogManager.getLogManager().readConfiguration(new FileInputStream("F:/apache-tomcat-7.0.72/webapps/contactSrvltlog/WEB-INF/classes/logging.properties"));
	DataSource ds=null;	
	Connection connection = null;
		Statement stmt = null;
		response.setContentType("text/html");

	
	String name=(String)request.getSession().getAttribute("a");
	//int id=generateId();
	String phone=(String)request.getSession().getAttribute("b");
	String place=(String)request.getSession().getAttribute("c");
	String emailId=(String)request.getSession().getAttribute("d");
	Context initCtx = new InitialContext();
	ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/datasource");
	connection=ds.getConnection();
	
	/*System.out.println("/////////**************"+name);
	System.out.println("/////////**************"+phone);
	System.out.println("/////////**************"+place);
	System.out.println("/////////**************"+emailId);*/
	LOGGER.info(">got values");
	
		
			

			stmt=connection.createStatement();
			String sql= "INSERT INTO contable(name,phoneNumber,place,emailID) "+"VALUES ('"+name+"','"+phone+"','"+place+"','"+emailId+"')";
			int i=stmt.executeUpdate(sql);
			if(i>0)                
			System.out.println("Inserted Successfully");              
			else                
			System.out.println("Insert Unsuccessful");    
			
			
			connection.close();
			response.sendRedirect("Contact.jsp?result=success");
		}
		catch(Exception e){
			LOGGER.info("exception catching");
			
			System.out.println(e);
			try{
			response.sendRedirect("Contact.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
		

	
	}
	
		
	public void doGet(HttpServletRequest request,HttpServletResponse response){
	Connection conn = null;
		Statement stmt = null;
		
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");

		stmt = conn.createStatement();
		String sql = "select * from contable";
		//System.out.println(""+sql);
		ResultSet rs = null;	
		rs = stmt.executeQuery(sql);
//System.out.println("rs/get"+rs);
		ArrayList<Contact> contacts=new ArrayList<Contact>();
        while (rs.next()) {
			Contact contact=new Contact(rs);
			/*contact.setName(rs.getString("name"));
			contact.setName(rs.getString("phoneNumber"));
			contact.setName(rs.getString("place"));
			contact.setName(rs.getString("emailId"));*/
			
			contacts.add(contact);
			request.getSession().setAttribute("Contact", contacts);
			
		
		}
		
		
		
		conn.close();
			
			response.sendRedirect("AllContact.jsp");
		
			
		}
	
	
	
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			try{
			response.sendRedirect("AllContact.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
	
	
	}
	
		
}