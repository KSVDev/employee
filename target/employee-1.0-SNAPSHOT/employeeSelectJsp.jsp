<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 11.12.2019
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.kozinets.employee.model.Employee" %>
<html>
<h3>Список сотрудников</h3>
<head>
    <title>SelectAll</title>
</head>
<body>
<form name="selectAllForm">
    <table cellpadding="0" cellspacing="5">
        <td><c:out value="Выбрать"/></td>
        <td><c:out value="ID"/></td>
        <td><c:out value="Департамент"/></td>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><input type="radio" name="flagEmployee"/></td>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
