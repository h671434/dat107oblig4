<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
	<title>Participant registration</title>
</head>

<body>
	<h2>Participant registration</h2>
	<p style="color:red;">${registrationViewMessage}</p>
	<form id="registration" action="registration" method="post">
		<fieldset>
			<label>First name</label>
			<input type="text" name="firstname" value="${registration.firstname}"/>
			
			<label>Last name</label>
			<input type="text" 	name="lastname" value="${registration.lastname}" />
			
			<label>Phone (8 digits)</label>
			<input type="text" name="phone" value="${registration.phone}" />
			
			<label>Password</label>
			<input type="password" name="password" value="${registration.password}"/>
			<label>Repeat password</label>
			<input type="password" name="repeatPassword" value="${registration.repeatPassword}" />
			
			<label>Gender</label> 
			<input type="radio" name="gender" value="Male" value="${registration.gender}" />Male
			<input type="radio" name="gender" value="Female" value="${registration.gender}" />Female
			     
			<br><br><button type="submit">Register</button>
		</fieldset>
	</form>
</body>
</html>
