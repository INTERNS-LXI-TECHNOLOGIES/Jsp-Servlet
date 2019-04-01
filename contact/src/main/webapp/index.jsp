<html>
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<head>
<title>Login</title>
</head>

<%
System.out.println(request.isUserInRole("user"));
System.out.println(request.isUserInRole("admin"));
if(request.isUserInRole("user")){
	session.setAttribute("username", request.getRemoteUser());
	RequestDispatcher reqD = request.getRequestDispatcher("lang");
	reqD.forward(request,response);
}

if(request.isUserInRole("admin")){
	RequestDispatcher reqD = request.getRequestDispatcher("/Registration.jsp");
	reqD.forward(request,response);
}

%>
</html>
