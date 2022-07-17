<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favourite Language Form</title>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/student/confirm" modelAttribute="student">
    <br><br>
    First Name*: <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>

    <br><br>
    Last Name*: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>

    <br><br>
    Age: <form:input path="age" placeholder="от 1 до 100"/>
    <form:errors path="age" cssClass="error"/>

    <br><br>
    Country:
    <form:select path="country">
        <form:options items="${countries}"/>
    </form:select>
    <form:errors path="country" cssClass="error"/>

    <br><br>
    Favourite Language:
    <form:radiobuttons path="favouriteLanguage" items="${languages}"/>
    <form:errors path="favouriteLanguage" cssClass="error"/>

    <br><br>
    Operating Systems:
    <form:checkbox path="operatingSystems" value="Linux" label="Linux"/>
    <form:checkbox path="operatingSystems" value="Windows" label="Windows"/>
    <form:checkbox path="operatingSystems" value="Mac OS" label="Mac OS"/>
    <form:errors path="operatingSystems" cssClass="error"/>


    <br><br>
    Course code:
    <form:input path="courseCode" placeholder="ex. LUV123"/>
    <form:errors path="courseCode" cssClass="error"/>

    <br><br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
