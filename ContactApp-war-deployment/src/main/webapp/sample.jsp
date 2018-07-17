<%@ page import = "com.lxisoftcontroller.*"%>
<%@ page import = "java.util.*"%>
<%@ page import = "com.lxisoft.model.*"%>
<%
NewContactController ncc = new NewContactController();
 Set<Contact>contactSet = ncc.contactDisplay();
if(contactSet!=null)
{	
 for(Contact contacts:contactSet)
 {
%>
<div id ="contact" align = "center" >
<a href = "ContactsInformation.jsp?name="<%=contacts.getFirstName()%></a></br>
</div>
<%
 }
}
%>

<div id = "jdbcread" align = "center">
<%@ page import = "java.sql.*"%>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select name,place,phn_no,email from contacts");
%>
<tbody>
<%while(rs.next()){%>
<tr>
<td>

<a href = "ContactsInformation.jsp?name=<%=rs.getString("name")%>">
<%=rs.getString("name")%>
</a>
</td>
</tr>
</br>
<%}%>

</tbody>
</div>
