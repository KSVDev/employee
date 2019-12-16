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
    <table  border ="1" width="500" align="left">
        <td><c:out value="Выбрать"/></td>
        <td><c:out value="ID"/></td>
        <td><c:out value="Сотрудник"/></td>
        <td><c:out value="Фамилия"/></td>
        <td><c:out value="Департамент"/></td>
        <td><c:out value="email"/></td>
        <td><c:out value="ДР"/></td>
        <td><c:out value="ЗП"/></td>
        <c:forEach var="employee" items="${employees}" varStatus="row">
            <tr>
                <td><input type="radio" name="employeeId" checked="checked" value="${employee.id}"/></td>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.surname}"/></td>
                <td><c:out value="${employee.department.name}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.birthday}"/></td>
                <td><c:out value="${employee.salary}"/></td>
            </tr>
        </c:forEach>
    </table>
    <table id="t2">
        <tr><input type="submit" formmethod="get" formaction="/employeeInsertJsp.jsp" value="Добавить" /></tr>
        <tr><input type="submit" formmethod="get" formaction="/employeeUpdateJsp.jsp" value="Редактировать"/></tr>
        <tr><input type="submit" formmethod="get" formaction="/employeeDeleteJsp.jsp" value="Удалить"/></tr>
        <tr><input type="submit" formmethod="get" formaction="/depart/select" value="Список департаментов"/></tr>
    </table>
</form>
</body>
</html>
