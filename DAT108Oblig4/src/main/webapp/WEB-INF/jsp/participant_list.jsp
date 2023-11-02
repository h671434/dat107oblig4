<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>List of participants</title>
</head>
<body>
    <p>Signed in as: ${user.phone} / ${user.fistname} ${user.lastname}</p>
	<h2>List of participants</h2>
	<table>
		<tr>
			<th>Gender</th>
			<th align="left">Name</th>
			<th align="left">Phone</th>
		</tr>
		<c:forEach items="${allParticipants}" var="participant">
        <tr style=>
			<td align="center">
			<c:choose>
				<c:when test="${participant.gender == 'Male'}">
					&#9794;
				</c:when>
				<c:otherwise>
					&#9792;
				</c:otherwise>
			</c:choose>
			</td>
			<td>${participant.firstname} ${participant.lastname}</td>
			<td>${participant.phone}</td>
		</tr>
		</c:forEach>

	</table>
	<br>
	<form action="logout" method="post">
	   <button type="submit">Log out</button> 
	</form>
</body>
</html>