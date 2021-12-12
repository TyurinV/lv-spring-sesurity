<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Huyaytel</title>
</head>
<body>
<h1> Users </h1>
<style>
    table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-collapse: collapse;
        text-align: center;
    }
    th, td:first-child {
        background: #AFCDE7;
        color: white;
        padding: 10px 20px;
    }
    th, td {
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: white;
    }
    td {
        background: #D8E6F3;
    }
    th:first-child, td:first-child {
        text-align: left;
    }
</style>
<table>
<tr>
    <th>id</th>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>Пол</th>
    <th>Курящий</th>
    <th>Действия</th>
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
