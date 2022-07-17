<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World - Input Form</title>
</head>
<body>
<br>
<form action="${pageContext.request.contextPath}/processName" method="post">
    <input type="text" name="studentName"
           placeholder="Enter your name"/>

    <input type="submit"/>
</form>
</body>
</html>
