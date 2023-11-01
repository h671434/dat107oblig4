<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<p style="color:red;">You are logged out</p>
	<form action="login" method="post">
		<fieldset>
			<label for="phone">Phone:</label> <input type="text" name="phone" />
			<label for="password">Password:</label> <input type="password" name="password" />
			<br><br><button type="submit" >Sign in</button>
		</fieldset>
	</form>

</body>
</html>