<html>
	<title>
	home page
	</title>
	<head></head>
	<body>
	<form action="addContactAction.jsp" method="get">
			<div id="main" style="margin: 100px; width: 80%; height: 400px; background: lightblue;  float: left; border-left: 10px solid #fff;">
			
			<table cellspacing="10" style="margin:80px;">
				<tr><th colspan="2"><h2>Add Contact</h2></th></tr>
				<tr><td height:"60"; width:"200">Name:</td><td height:"60"; width:"200"><input type="text" name="name"></td></tr>
				<tr><td height:"60"; width:"200">Place:</td><td height:"60"; width:"200"><input type="text" name="place"></td></tr>
				<tr><td height:"60"; width:"200">Phone Number:</td><td height:"60"; width:"200"><input type="text" name="phoneNumber"></td></tr>
				<tr><td height:"60"; width:"200">Email:</td><td  height:"60"; width:"200"><input type="text" name="email"></td></tr>
				<tr><td><input type="submit" name="submit" value="submit"></td><td><input type="button" name="cancel" value="cancel"></td></tr>
			</table>

			</div>
	</form>
	</body>
</html>