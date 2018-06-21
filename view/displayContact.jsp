<html>
<!..displayContact...>
<head>

</head>
<body>
<style>
body
{
	background-color:white;
}

</style>

<%@ page import = "com.lxisoft.controller.*"%>
<%@ page import = "java.util.*"%>
<%@ page import = "com.lxisoft.model.*"%>
<%
ContactFile cf = new ContactFile();
String[] data = cf.readData();
if(data.length()!=null)
{	
 for(i = 0;i<data.length()-1;data.length())
 {
%>

<input type = "button" class = "button1" value = "<%=data[i]%>"/>
<%
 }
}
%>
</body>

</html>