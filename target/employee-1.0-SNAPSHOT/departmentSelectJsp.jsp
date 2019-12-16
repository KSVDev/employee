<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.kozinets.employee.model.Department" %>
<!-- cellpadding="0" cellspacing="5" -->
<html>
    <h3>Список департаментов</h3>
    <head>
        <title>SelectAll</title>
    </head>
    <body>
        <form name="selectAllForm">
            <table id="t1" border ="1" width="500" align="left">
                <td><c:out value="№"/></td>
                <td><c:out value="ID"/></td>
                <td><c:out value="Департамент"/></td>
                <td><c:out value="Выбрать"/></td>
                <c:forEach var="department" items="${departments}" varStatus="row">
                    <tr>
                        <td><c:out value="${row.index}"/></td>
                        <td><c:out value="${department.id}"/></td>
                        <td><c:out value="${department.name}"/></td>
                        <td><input type="radio" name="departmentId" checked="checked" value="${department.id}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <table id="t2">
                <tr><input type="submit" formmethod="get" formaction="/departmentInsertJsp.jsp" value="Добавить" /></tr>
                <tr><input type="submit" formmethod="get" formaction="/departmentUpdateJsp.jsp" value="Редактировать"/></tr>
                <tr><input type="submit" formmethod="get" formaction="/departmentDeleteJsp.jsp" value="Удалить"/></tr>
                <tr><input type="submit" formmethod="get" formaction="/empl/select" value="Список сотрудников"/></tr>
            </table>
        </form>
    </body>
</html>