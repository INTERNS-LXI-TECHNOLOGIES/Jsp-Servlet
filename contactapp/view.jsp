<%@ page import= "com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>

</head>

<body>

<center><p><h2>ContactList</h2></p></center><br><br>
<center> <table>
<tr>
    <th><pre class="tab"><h3>            Contactname           </h3></pre></th>
    <th><pre class="tab"><h3>            phoneNumber           </h3></pre></th>
  </tr> 
<%
RepositoryImpl re=new RepositoryImpl();
ArrayList<Contact> list=new ArrayList<Contact>();
re.view(list);
for(int i=0;i<list.size();i++)

		{%>
		<tr>
		<td><%out.println(list.get(i).getName());%></td>
		<td><%out.println(list.get(i).getPhoneNumber());%></td>
		</tr>
		<%}

%>
</table>
</center>
<br>
<center>
<div><a href="edit.html">Edit</a></div><div>   <a href="delete.html">Delete</a></div>   <div><a href="create.html">Create</a></div>
</center>
<a href="view.html">Back<br></br></a>
</body>
</html>