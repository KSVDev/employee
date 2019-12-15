<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 11.12.2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- cellpadding="0" cellspacing="5" -->
<html>
<h3>Удалить департамент</h3>
<head>
    <title>DeleteDepartment</title>
</head>
<body>
<form name="">
    <table>
        <tr><input type="hidden" name="flagDepartment" value="<%= request.getParameter("flagDepartment") %>" /></tr>
        <tr><input type="submit" name="Удалить" formmethod="post" formaction="/depart/delete" value="Удалить"/></tr>
    </table>

</form>
</body>
</html>