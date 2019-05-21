<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 25%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: SlateBlue;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 15%;
}

button:hover {
  opacity: 0.8;
}
</style>
</head>
<body>
<form action="login">
Username:<input id="username" type="text" placeholder="Enter Username" name="username" required>
<br>
Password:<input id="password" type="password" placeholder="Enter Password" name="password" required>
<br>
<input type="checkbox" onclick="myFunction()">Show Password 
<button type="submit"value="Submit">Login</button>
</form>
<script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type == "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>

</body>
</html>
