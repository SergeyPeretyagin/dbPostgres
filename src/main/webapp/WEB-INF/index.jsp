<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        TABLE {
            width: 400px; /* Ширина таблицы */
            border: 5px solid black; /* Рамка вокруг таблицы */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого ячеек */
            text-align: center; /* Выравнивание по центру */
        }
        TH {
            background: black; /* Цвет фона */
            color: white; /* Цвет текста */
        }
    </style>
</head>
<body>
<h2>User List</h2>
<p><a href='<c:url value="/create"/>'>Create new user</a></p>
<table cellspacing="0">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Operation</th>
    </tr>
    <c:forEach var="user" items="${users}" >
        <c:url var="updateButton" value="/update">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/delete">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.age}</td>
            <td>
                <input type="button" value="Update"
            onclick="window.location.href='${updateButton}'">
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
