<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<style>
h1{
border-left: 2px;
  width:150px;
  color:white;
  top: 100%;
  text-align:center;
border-radius:50px;
font-family:"Courier New";
background-color:slateblue;
}
{
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 85%;
}


td,th {
  border: 1px ;
  padding: 4px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
font-family:"Courier New";
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: white;
  color: grey;
  width:200px;
}

.row{
	width:100%;
}
.c
.col{
width:20%;
height:40%;
display:inline-block;
padding:10px;
}


</style>
</head>
<body>
<div>

	<div class="row">
		
		<div class="col">
			<h1>Contact</h1>
		</div>
		
		<div class="col">
		
		  <form action="search">
		    <input type="text" placeholder="Search.." name="search">
		    <button type="submit"><i class="fa fa-search"></i></button>
		  </form>	
		  </div>
		
		</div>
	
	</div>
	
	<div class="row">
	 <div class="col">
		<table id="customers">
		  <tr>
		    <th>NAME</th>
		    <th>NUMBER</th>
		    <th>EMAIL</th>
		  </tr>
		</table>
	</div>	
	</div>


</div>
</body>
</html>
  