<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

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

<br>
<div id="wrapper">
    <div id="header">
        <h3>Customers list</h3>
    </div>
</div>

<div id="container">
    <div id="content">

        <button type="button" class="btn btn-outline-secondary"
                onclick="window.location.href='add-form'; return false;">Add customer
        </button>
        <form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/customers/search">
            <input class="form-control mr-sm-4" type="search" placeholder="Search" aria-label="Search" name="searchName">
            <input type="submit" value="Search" class="btn btn-outline-success my-2 my-sm-0"/>

        </form:form>

        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}">

                <c:url var="updateLink" value="/customers/edit-form">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customers/delete">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>

                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="actionsGroup">
                            <button type="button" class="btn btn-outline-info btn-sm"
                                    onclick="window.location.href='${updateLink}'; return false;">Update</button>
                            <button type="button" class="btn btn-outline-danger btn-sm"
                                    onclick="if (confirm('The customer will be deleted permanently! Are you sure you want to delete the customer?')) window.location.href='${deleteLink}'; return false;">Delete</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<c:if test="${wasAdded}">
    <div class="alert alert-success" role="alert">
        Successfully added!
    </div>
</c:if>
<c:if test="${wasUpdated}">
    <div class="alert alert-success" role="alert">
        Successfully updated!
    </div>
</c:if>
<c:if test="${wasDeleted}">
    <div class="alert alert-success" role="alert">
        Successfully deleted!
    </div>
</c:if>

<br>
<hr class="my-4">
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Customers</li>
    </ol>
</nav>
</body>
</html>
