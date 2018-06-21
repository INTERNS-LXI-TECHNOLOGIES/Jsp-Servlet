<html>
<!...new Contact..>
<%@ page import = "com.lxisoft.controller.*"%> 
<%String name  = request.getParameter("Name");
String place = request.getParameter("Place");
String phn_no = request.getParameter("phn_no");
String email = request.getParameter("Email");
//out.println(name);
ContactFile cf = new ContactFile();
cf.addData(name,place,phn_no,email);
String direction = "loginPage.jsp";
response.sendRedirect(direction);
%>

</html>