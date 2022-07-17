<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring 5 MVC Home Page</title>
</head>
<body>
<a href="showForm">${helloObject}</a>
<br>
<a href="${pageContext.request.contextPath}/student/register">Login</a>
</body>
</html>
