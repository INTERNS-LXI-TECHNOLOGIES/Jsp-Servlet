<%@page import="com.lxisoft.camp.Question"%>
<%@page import="com.lxisoft.camp.Quiz"%>
<%@page import="java.sql.*"%>
<html>
<head>
Question
</head>
<body>
</br>
<%
String ques=request.getParameter("question");
String opt1=request.getParameter("option1");
String opt2=request.getParameter("option2");
String opt3=request.getParameter("option3");
String opt4=request.getParameter("option4");
String ans=request.getParameter("answer");
Question que=new Question();
que.question=ques;
que.option1=opt1;
que.option2=opt2;
que.option3=opt3;
que.option4=opt4;
que.answer=ans;

if(session.getAttribute("quiz")==null)
{
	session.setAttribute("quiz",new Quiz());
}
if(session.getAttribute("quiz")!=null)
{
	Quiz q = (Quiz)session.getAttribute("quiz");
	if(q.q1==null)
	{
		q.q1=que;
	}
	else if(q.q2==null)
	{
		q.q2=que;
	}
	else if(q.q3==null)
	{
		q.q3=que;
	}
	else if(q.q4==null)
	{
		q.q4=que;
	}	
	
}
Quiz q=(Quiz)session.getAttribute("quiz");
if(q.q1!=null)
{
out.println(q.q1.question);
out.println(q.q1.option1);
out.println(q.q1.option2);
out.println(q.q1.option3);
out.println(q.q1.option4);
out.println(q.q1.answer);
}
if(q.q2!=null)
{
out.println(q.q2.question);
out.println(q.q2.option1);
out.println(q.q2.option2);
out.println(q.q2.option3);
out.println(q.q2.option4);
out.println(q.q2.answer);
}if(q.q3!=null)
{
out.println(q.q3.question);
out.println(q.q3.option1);
out.println(q.q3.option2);
out.println(q.q3.option3);
out.println(q.q3.option4);
out.println(q.q3.answer);
}if(q.q4!=null)
{
out.println(q.q4.question);
out.println(q.q4.option1);
out.println(q.q4.option2);
out.println(q.q4.option3);
out.println(q.q4.option4);
out.println(q.q4.answer);
}
Connection con=null;
		
	 ResultSet rs;
	 PreparedStatement ps;
	 
	 Class.forName("com.mysql.cj.jdbc.Driver");
	//out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db","root","root");
	  
	 ps=con.prepareStatement("insert into question(question,option1,option2,option3,option4,answer) values('"+que.question+"','"+que.option1+"','"+que.option2+"','"+que.option3+"','"+que.option4+"','"+que.answer+"')");
	 ps.executeUpdate();
	 out.println("hshhshs");
	 ps=con.prepareStatement("select * from question");
	 rs=ps.executeQuery();
	
	
	
%>
<br>
<a href="index.html">back </a>
</body>
</html>