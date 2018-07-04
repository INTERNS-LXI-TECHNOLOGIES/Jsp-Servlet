<html>
	<title>
	home page
	</title>
	<head></head>
	<body>
	<form action="servletAddContact" method="post">
	
			<table cellspacing="10" style="background: lightblue;margin-left: 250px;margin-top:100px; width: 50%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
				<tr><th colspan="2"><h2>Add Contact</h2></th></tr>
				<tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
				<tr><td>Place:</td><td><input type="text" name="place" required></td></tr>
				<tr><td>Phone Number:</td><td><input type="text" name="phoneNumber" pattern="\d{10}" required></td></tr>
				<tr><td>Email:</td><td><input type="email" name="email" required></td></tr>
				<tr><td><input type="submit" name="submit" value="submit"></td><td><input type="button" name="cancel" value="cancel"></td></tr>
			</table>

	</form>
	</body>
	
</html>