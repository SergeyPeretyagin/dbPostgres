<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<section>
<%--    <jsp:useBean id="user" scope="request" type="database.model.User"/>--%>
    <form method="post">
        <dl>
            <dt>Name: </dt>
            <dd><input type="text" name="name" value="${user.name}" placeholder="${user.name}" /></dd>
        </dl>
        <dl>
            <dt>Name: </dt>
            <dd><input type="text" name="surname" value="${user.surname}" placeholder="${user.surname}" /></dd>
        </dl>
        <dl>
            <dt>Serial number: </dt>
            <dd><input type="number" name="age" value="${user.age}" placeholder="${user.age}" /></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>
