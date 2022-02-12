<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="post" >--%>
<%--    <label>Name</label><br>--%>
<%--    <input name="name"/><br><br>--%>
<%--    <label>Surname</label><br>--%>
<%--    <input name="surname"/><br><br>--%>
<%--    <label>Age</label><br>--%>
<%--    <input name="age" type="number" /><br><br>--%>
<%--    <input type="submit" value="Save" />--%>
<%--</form>--%>
<form method="post" var="user" items="${user}">
    <dl>
        <dt>Name: </dt>
        <dd><input type="text" name="name" value="${user.name}" /></dd>
    </dl>
    <dl>
        <dt>Name: </dt>
        <dd><input type="text" name="surname" value="${user.surname}"  /></dd>
    </dl>
    <dl>
        <dt>Serial number: </dt>
        <dd><input type="number" name="age" value="${user.age}"  /></dd>
    </dl>
    <button type="submit">Save</button>
</form>
</body>
</html>
