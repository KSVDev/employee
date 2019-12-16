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
<h3>Добавить департамент</h3>
<head>
    <title>InsertDepartment</title>
</head>
<body>
<form name="f1">
    <table>
        <tr><input type="text" name="NewDepartmentName" value=""/></tr>
        <tr><input type="submit" name="Добавить" formmethod="post" formaction="/depart/insert" value="Добавить"/></tr>
    </table>
</form>
</body>
</html>