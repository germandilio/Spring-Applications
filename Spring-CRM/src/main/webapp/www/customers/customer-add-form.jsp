<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <title>Add Customer</title>

    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd; ">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">CRM System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/"><span class="sr-only">Home</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/customers/list">Customers</a>
            </li>
        </ul>
    </div>
</nav>

<form:form action="${pageContext.request.contextPath}/customers/confirm-add" method="post" modelAttribute="customer">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="firstName">First name</label>
            <form:input type="text" class="form-control" id="firstName" placeholder="Enter first name"
                        path="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="form-group col-md-6">
            <label for="lastName">Last name</label>
            <form:input type="text" class="form-control" id="lastName" placeholder="Enter last name" path="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="email">Email address</label>
            <form:input type="email" class="form-control" id="email" placeholder="name@example.com"
                        aria-describedby="emailHelp" path="email"/>
            <form:errors path="email" cssClass="error"/>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
    </div>
    <br>
    <form:button type="submit" class="btn btn-primary">Save</form:button>
</form:form>

<br>
<hr class="my-4">
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/customers/list">Customers</a></li>
        <li class="breadcrumb-item active" aria-current="page">Add</li>
    </ol>
</nav>
</body>
</html>
