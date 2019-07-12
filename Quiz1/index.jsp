<%@page import="com.lxisoft.camp.Question" %>
<%@page import="com.lxisoft.camp.Quiz" %>
<%@page import="java.sql.*" %>
<html>
<head>

</head>
<body>

<%
	PreparedStatement ps;
	Question q=new Question();
	q.question=request.getParameter("question");
	q.option1=request.getParameter("option1");
	q.option2=request.getParameter("option2");
	q.option3=request.getParameter("option3");
	q.option4=request.getParameter("option4");
	q.answer=request.getParameter("answer");
	//out.println(q.printData());
	//for(int i=0;i<4;i++)
	//{
	if(session.getAttribute("Quiz")==null)
	{   
		Quiz quiz=new Quiz();
		session.setAttribute("Quiz",quiz);
	}
	else
	{
		Quiz quiz=(Quiz)session.getAttribute("Quiz");
		if(quiz.q1==null)
		{   
			quiz.q1=q;
		}
		else if(quiz.q2==null)
		{
			quiz.q2=q;
		}
		else if(quiz.q3==null)
		{
			quiz.q3=q;
		}
		else 
		{
			quiz.q4=q;
		}

		Quiz myq=(Quiz)session.getAttribute("Quiz");
%>
	<table border="1" width="60%">
	<tr>
		<td>       </td>
		<td>Questions</td>
		<td>Option1</td>
		<td>Option2</td>
		<td>Option3</td>
		<td>Option4</td>
		<td>answer</td>
     </tr>

     <tr>
     	<td>q1</td>
     	<td><%=quiz.q1.question%></td>
     	<td><%=quiz.q1.option1%></td>
     	<td><%=quiz.q1.option2%></td>
     	<td><%=quiz.q1.option3%></td>
     	<td><%=quiz.q1.option4%></td>
     	<td><%=quiz.q1.answer%></td>
     </tr>
     <tr>
     	<td>q2</td>
     	<td><%=quiz.q2.question%></td>
     	<td><%=quiz.q2.option1%></td>
     	<td><%=quiz.q2.option2%></td>
     	<td><%=quiz.q2.option3%></td>
     	<td><%=quiz.q2.option4%></td>
     	<td><%=quiz.q2.answer%></td>
     </tr>
     <tr>
     	<td>q3</td>
     	<td><%=quiz.q3.question%></td>
     	<td><%=quiz.q3.option1%></td>
     	<td><%=quiz.q3.option2%></td>
     	<td><%=quiz.q3.option3%></td>
     	<td><%=quiz.q3.option4%></td>
     	<td><%=quiz.q3.answer%></td>
     </tr>
     <tr>
     	<td>q4</td>
     	<td><%=quiz.q4.question%></td>
     	<td><%=quiz.q4.option1%></td>
     	<td><%=quiz.q4.option2%></td>
     	<td><%=quiz.q4.option3%></td>
     	<td><%=quiz.q4.option4%></td>
     	<td><%=quiz.q4.answer%></td>
     </tr>
	 </table>

<% 
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db","root","root");

		ps=con.prepareStatement("insert into question(question_no,question,option1,option2,option3,option4,answer)values (5,'"+quiz.q1.question+ "','"+quiz.q1.option1+ "','"+quiz.q1.option2+ "','"+quiz.q1.option3+ "','"+quiz.q1.option4+ "','"+quiz.q1.answer+ "')");
		ps.executeUpdate();


		ps=con.prepareStatement("select * from question");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String s=rs.getString("question")+rs.getString("option1")+rs.getString("option2")+rs.getString("option3")+rs.getString("option1")+rs.getString("answer");
			out.println(s);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
%>
<a href="index.html"></br></br>Back to html
	</a>
</body>
</html>