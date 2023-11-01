<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Registration successful</title>
</head>
<body>
	<h2>Registration successful</h2>
	<p>Registration recieved for</p>
	<p>
		${participant.firstname}<br />
		${participant.lastname}<br />
		${participant.phone}<br /> 
		${participant.gender}
	</p>
	<a href="participants_list">Go to list of participants</a>
</body>
</html>