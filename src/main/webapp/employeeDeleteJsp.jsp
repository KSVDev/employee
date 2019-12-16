<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<h3>Удалить сотрудника: ${employeeName}</h3>
<head>
    <title>DeleteEmployee</title>
</head>
<body>
<form name="f1">
    <table>
        <tr><input type="hidden" name="employeeId" value="${param.employeeId}" /></tr>
        <tr><input type="submit" name="Удалить" formmethod="post" formaction="/empl/delete" value="Удалить"/></tr>
    </table>

</form>
</body>
</html>