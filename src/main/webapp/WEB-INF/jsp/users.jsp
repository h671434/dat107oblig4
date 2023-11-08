<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table border="1">
    <tr>
        <th>Phone number </th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender </th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.phone}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
