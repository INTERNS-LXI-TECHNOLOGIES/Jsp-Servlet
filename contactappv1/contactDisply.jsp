<!DOCTYPE html>
<html>
<head>
<title> Displaying...</title>
</head>

<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxosoft.model.*,java.io.*"%>


<%
	File file=new File("D:/lxisoft.app/apache-tomcat-8.5.38/webapps/contactappv1/data/Contacts.txt");
	String line; %>
	<body>
	<%out.println("CONTACTS");%>
	<%try{
	FileReader fr= new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	while((line=br.readLine())!=null){
	String[] data = line.split(",");
	out.println("\n\n"+data[0]);
	
	}
	}catch(IOException e){
			
			System.out.println("Error");
			out.println("Error");}	
%>
</html>