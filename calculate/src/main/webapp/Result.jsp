<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="index.css">

<title>Result</title>
</head>
<body>
	<div>
	<%
	int result =Integer.parseInt(request.getAttribute("result").toString());
	%>
	<%=
	result
	%>
	</div>
</body>
</html>