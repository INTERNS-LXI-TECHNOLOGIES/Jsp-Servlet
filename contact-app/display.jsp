<!DOCTYPE html>
<html>
<head>
	<title>displaying</title>
</head>
<%@ page import="java.util.*,java.io.*"%>
    <% 
	{
		File file=new File("D:/Project/tomcat/webapps/contact-app/data/ContactList.txt");
		FileReader fr=null;
		BufferedReader br=null;
	try{
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String line;
			%>
	<body align="center">
			<h1 align="center">Contact lists</h1><br><br>
			<ol>
		<%	while((line=br.readLine())!=null){

			String data[]=line.split(";");
		
			
		
		%>


	<li><% out.println(data[0]+"  "+data[1]); %></li><br>
	
	<%
	}%>
</ol>
	<%
}
catch(Exception e){
	
	e.printStackTrace();
}
}
%>
<br><br><a href="home.html">Home</a>


</body>
</html>