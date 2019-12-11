<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 11.12.2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form name="departmentsForm" method="post" action="/depart/select">
    <table>
        <tr>
            <td><input type="submit" value="Список сотрудников"/></td>
            <td><input type="submit" value="Добавить"/></td>
            <td><input type="submit" value="Удалить"/></td>
            <td><input type="submit" value="Редактировать"/></td>
        </tr>
    </table>
</form>
</body>
</html>
