<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 11.12.2019
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="selectForm" method="post" action="/depart/select">
    <table>
        <tr>
            <td><input type="submit" value="Список сотрудников"/></td>
        </tr>
    </table>
</form>
<form name="insertForm" method="post" action="/depart/insert">
    <table>
        <tr>
            <td><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form>
<form name="deleteForm" method="post" action="/depart/delete">
    <table>
        <tr>
            <td><input type="submit" value="Удалить"/></td>
        </tr>
    </table>
</form>
<form name="updateForm" method="post" action="/depart/update">
    <table>
        <tr>
            <td><input type="submit" value="Редактировать"/></td>
        </tr>
    </table>
</form>

</body>
</html>
