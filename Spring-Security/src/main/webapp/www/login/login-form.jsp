<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    <title>Login Page</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/login/processing" method="post">
    <h3>Login</h3>
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <i>Invalid password or username</i>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-info">
            <i>You have been logout.</i>
        </div>
    </c:if>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" id="username" placeholder="ex. germandilio" name="username">
        <label for="username">User name</label>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="password" placeholder="Password" name="password">
        <label for="password">Password</label>
    </div>
    <br>
    <div class="col-auto">
        <button type="submit" class="btn btn-primary mb-3">Login</button>
    </div>
</form:form>
</body>
</html>
