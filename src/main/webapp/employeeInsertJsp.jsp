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
<h3>Добавить сотрудника</h3>
<head>
    <title>InsertEmployee</title>
</head>
<body>
<form name="f1">
    <label>Имя:</label>
    <input type="text" name="NewEmployeeName" value=""/> <br/>
    <label>Фамилия:</label>
    <input type="text" name="NewEmployeeSurname" value=""/> <br/>
    <label>Департамент:</label>
    <input type="text" name="NewEmployeeDepartment" value="${departmentId}"/> <br/>
    <label>email:</label>
    <input type="text" name="NewEmployeeEmail" value=""/> <br/>
    <label>ДР:</label>
    <input type="text" name="NewEmployeeBirthday" value=""/> <br/>
    <label>ЗП:</label>
    <input type="text" name="NewEmployeeSalary" value=""/> <br/>

    <input type="submit" name="Добавить" formmethod="post" formaction="/empl/insert" value="Добавить"/>
</form>
</body>
</html>