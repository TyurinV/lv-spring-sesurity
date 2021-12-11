<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Huyaytel</title>
</head>
<body>
<h1> Users </h1>
<table>
<tr>
    <th>id</th>
    <th>firstName</th>
    <th>lastName</th>
    <th>sex</th>
    <th>smoker</th>
</tr>
<c:forEach var="user" items="${userList}">
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.sex}</td>
        <td>${user.smoker}</td>
            <td>
            <a href="/edit/${user.id}">edit</a>
            <a href="/delete/${user.id}">delete</a>
            </td>
    </tr>
</c:forEach>
</table>

<h2> add </h2>
<c:url value="/add" var="add"/>
<a href ="${add}">Add new</a>


    </body>
    </html>
