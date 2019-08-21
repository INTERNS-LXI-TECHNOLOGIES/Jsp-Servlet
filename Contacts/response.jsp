<%@ page import ="com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Response Page</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>
		<%
			
			if(session!=null)
			{
				ArrayList<Contact> contactList=(ArrayList<Contact>)session.getAttribute("list");
				int n=contactList.size();
				//out.println("Size :"+n);
				String name=contactList.get(n-1).getName();
				String number=contactList.get(n-1).getNumber();
				out.println("Contact "+name+"("+number+") added successfully");

			}
			
		%>
</body>
</html>



	<!-- for(int i=0;i<contactList.size();i++)
					{
						out.println(contactList.size());
						//contactList.get(i).getId();
						name=contactList.get(i).getName();
						//contactList.get(i).getNumber();
						out.println("name :"+name);
					}
					 -->


