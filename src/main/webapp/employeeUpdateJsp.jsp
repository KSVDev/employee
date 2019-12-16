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
<h3>Изменить данные сотрудника: ${employeeName}</h3>
<head>
    <title>UpdateEmployee</title>
</head>
<body>
<form name="updateEmployee">
    <p>
        <input type="text" name="employeeId" value="${param.employeeId}"/><br/>
            </p>
            <p>
                <label>Имя:</label>
                <input type="text" name="employeeName" value="${employeeName}"/><br/>
            </p>
            <p>
                <label>Фамилия:</label>
                <input type="text" name="employeeSurname" value="${employeeSurname}"/><br/>
            </p>
            <p>
                <label>Департамент:</label>
                <input type="text" name="departmentId" value="${departmentId}"/><br/>
            </p>
            <p>
                <label>email:</label>
                <input type="text" name="employeeEmail" value="${employeeEmail}"/><br/>
            </p>
            <p>
                <label>ДР:</label>
                <input type="text" name="employeeBirthday" value="${employeeBirthday}"/><br/>
            </p>
            <p>
                <label>ЗП:</label>
                <input type="text" name="employeeSalary" value="${employeeSalary}"/><br/>
            </p>
            <table>
                <tr>
                    <input type="submit" formmethod="post" formaction="/empl/update" />
                </tr>
            </table>
        </form>
    </body>
</html>