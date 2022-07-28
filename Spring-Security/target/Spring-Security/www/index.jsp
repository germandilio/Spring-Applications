<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    <title>Home page</title>
</head>
<body>
This is from Spring Security demo app
<br>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit" value="Logout" class="btn btn-primary">Logout</button>
</form:form>
<br>
<security:authorize access="hasRole('MANAGER')">
    Only for Managers:
    <br>
    <a href="${pageContext.request.contextPath}/leaders/" class="btn btn-primary">Manager Console</a>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
    <br>
    Only for Admins:
    <br>
    <a href="${pageContext.request.contextPath}/systems/" class="btn btn-primary">Admin Console</a>
</security:authorize>
<hr>
<br>
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Authorities (Roles): <security:authentication property="principal.authorities"/>
    </p>
<hr>
</body>
</html>
