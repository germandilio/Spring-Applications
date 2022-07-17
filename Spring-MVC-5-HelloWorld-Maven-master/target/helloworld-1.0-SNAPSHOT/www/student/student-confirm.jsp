<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation Page</title>
</head>
<body>
Success!!!
<br>
You entered:
<br>
First name: |${student.firstName}|
<br>
Last name: |${student.lastName}|
<br>
Age: |${student.age}|
<br>
Country: |${student.beatifyCountry}|
<br>
Favourite language: |${student.favouriteLanguage}|
Performed operating systems:
<ul>
    <c:forEach var="os" items="${student.operatingSystems}">
        <li><c:out value="${os}"/></li>
    </c:forEach>
</ul>

<br>
Course code: |${student.courseCode}|

</body>
</html>
