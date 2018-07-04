<html>
	<head>
		<title>used for add contacts</title>
		<link rel="stylesheet" type="text/css" href="Them1.css"/>
		<%@  page import = "com.lxisoft.controller.*,com.lxisoft.model.*,java.io.*"%>
	</head>
	<style>
		body
		{
		background-color:green;
		}
		
	</style>
	<body>
	
	<div id="top"> 
	<h2 align="center"><i>Done</i></h2></br>
	</div>

	<a href="Contacts.jsp"><img src="/Contactsv1.2/images/homeIcon.ico" height="50" width></a></br>

		<div id="top">
		Name   :<%out.println(request.getParameter("name"));%></br>
		</div></br>
		<div id="top">
		Phone :<%out.println(request.getParameter("phone"));%></br>
		</div>
		<% 
			ContactController cc=new ContactController();
			
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String sid=request.getParameter("id");
			System.out.println("add2/sid=="+sid);
			int id;
			
			if(sid==null)
			{
				cc.check(0,name,phone);
			}
			else
			{
				id=Integer.parseInt(sid);
				cc.check(id,name,phone);
			}
		%>
	</body>
</html>