<%@ page import= "com.lxisoft.contact.model.ContactModel,com.lxisoft.contact.repo.RepositoryImpl"%>
<%@ page import="java.sql.*"%>
<%@ ArrayList<ContactModel>contacts=new ArraList<ContactModel>();
	RepositoryImpl ri=new RepositoryImpl();
	ContactModel cm=new ContactModel();

%>
<html>
    <head>
    <title> index </title>
</head>
<body>
<%
ContactModel cm=new ContactModel();
String firstName=request.getParameter("username");
String phone_number=request.getParameter("userphonenumber");
String mail_id=request.getParameter("usermailid");
cm.setName(username);
phno.add(phone_number);
cm.setPhoneNumber(phno);
cm.setMailId(mail_id);
ri.createContact(cm);
%>
<%
String b=request.getParameter("name");
String d=request.getParameter("new name");
String tb="contactlist";
String c="Name";
si.updateContact(tb,c,b,d);
%>
<%
String nbr="PhoneNumber";
String tbn="contactnumber";
String number=request.getParameter("number");
String newnumber=request.getParameter("newnumber");
si.updateContact(tbn,nbr,number,newnumber);
%>
<%
String tbna="Contactlist";
String ml="Email_id";
String email=request.getParameter("email");
String mail=request.getParameter("mail");
si.updateContact(tbna,ml,email,mail);
%>
<%
String namer=request.getParameter("nam");
String numbr=request.getParameter("num");
si.searchContact(namer,numbr);
%>
<%
String n=request.getParameter("n");
ri.deleteContact(n);
%>

<a href="contact.html"><tr>go back</tr></br></br></a>
</body>
</html>