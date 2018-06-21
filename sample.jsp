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