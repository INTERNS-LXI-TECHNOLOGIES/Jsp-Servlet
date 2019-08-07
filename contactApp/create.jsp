<%@ page import= "com.lxisoft.contact.ContactModel"%>
<%@ page import= "com.lxisoft.contact.RepositoryImpl"%>
<%@ page import="java.sql.*"%>
<%@ page import ="java.util.*"%>
<%ArrayList <ContactModel> contacts=new ArrayList <ContactModel>();
	RepositoryImpl ri=new RepositoryImpl();

%>
<html>
    <head>
    <title> create </title>
</head>
<body>
<%
ContactModel c=new ContactModel();
String firstName=request.getParameter("Your First Name");
String lastName=request.getParameter("Your Last Name");
String phone=request.getParameter("Phone Number");
String mobNumber=request.getParameter("Mobile Number");
String email=request.getParameter("Your email");
c.setFirstName(firstName);
c.setLastName(lastName);
c.setPhone(phone);
c.setMobNumber(mobNumber);
c.setEmail(email);
ri.addContact(c);
%>

<a href="create.html"><tr>go back</tr></br></br></a>
</body>
</html>