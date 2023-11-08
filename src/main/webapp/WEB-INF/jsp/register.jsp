<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Greeting Page</title>
</head>
<body>
<h1>Welcome, ${user.firstName}!</h1>
<p>Click <a href="<%= request.getContextPath() %>/showAttendees">here</a> to see all attendees.</p>
</body>
</html>
