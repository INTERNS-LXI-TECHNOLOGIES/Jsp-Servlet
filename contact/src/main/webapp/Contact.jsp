<%@ page import = "com.lxisoft.model.ContactDetails" %>
<%@ page import = "com.lxisoft.controller.*" %>
<%@ page import = "java.util.*" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'>
	
	<title>Contacts</title>
	<script type="text/javascript">
	
	function lang(){}
	if(document.getElementById("lang").value=="true"){
		document.getElementById("lang").value = "flase"
	}
	else{
		document.getElementById("lang").value = "true"
	}
	
)
	
	</script>
</head>
<body>

<h1 class ="h1"> ContactApp</h1>

<form action = "search" >
<input class = "search" type="text" name="search" placeholder="Search">
<button class = "searchb" type="submit" title = "Search"><i class="fa fa-search"></i></button>
</form>
<form action = "logout" >
<button class = "logb" type="submit" title = "LogOut"><i id = "h" class="fas fa-sign-out-alt"></i></button>

</form>
	
	<button class = "langa" onclick="window.location.href='lang?l=false'">Eng</button>
	<button class = "lang" onclick="window.location.href='lang?l=true'">Mal</button>
	<button class = "prev" onclick="window.location.href='contacts?prev=true'"><</button>
	<button class = "next" onclick="window.location.href='contacts?next=true'">></button>
	

<form action = "AddContact.jsp" >
	<button   class = "contactbutton" type = "submit" title = "Add Contact">+</button>
</form>
	<%
	
	List<ContactDetails> contacts =(List<ContactDetails>) request.getAttribute("contacts");
	Locale l = null;
	if((String)session.getAttribute("lang") != null){
	l = new Locale((String)session.getAttribute("lang"),(String)session.getAttribute("cont"));
	}
	else{
	l = new Locale("ml","IN");
	}
	boolean a = false;
	ResourceBundle r = ResourceBundle.getBundle("lang",l);
	
	%>
	<table>
		<tr>
			<th><%=r.getString("name")%></th>
			<th><%=r.getString("emailid")%></th>
			<th><%=r.getString("no")%></th>
		</tr>
		<%
			for(int i =0;i<contacts.size();i++){
			
		%>
		<tr>
			<td><%=contacts.get(i).getName()%></td>
			<td><%=contacts.get(i).getEmailid()%></td>
			<td><%=contacts.get(i).getNumber()%></td>
			<td><a href="EditContact.jsp?id=<%=contacts.get(i)%>"><button id = "edit" class = "editbl" type="submit" title = "Edit"><i class="fas fa-pencil-alt"></i></button></a>
			<a href="deletecontact?id=<%=contacts.get(i).getId()%>"><button id = "edit" class = "editbl" type="submit" title = "Delete"><i class="far fa-file-excel"></i></button></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>