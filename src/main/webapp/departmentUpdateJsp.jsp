<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 11.12.2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.kozinets.employee.model.Department" %>
<!-- cellpadding="0" cellspacing="5" -->
<html>
    <h3>Введите новое имя департамента</h3>
    <head>
        <title>UpdateDepartment</title>
    </head>
    <body>
        <c:set var="flagDepartment1" value='${requestScope["flagDepartment"]}' />
        <form name="updateDepartment">
            <p>
                <c:out value='${flagDepartment}' /><br/>
                <input type="text" name="flagDepartment1" value='${flagDepartment}'/><br/>
                <input type="text" name="NewDepartmentName" value="sss"/>
            </p>
            <table>
                <tr>
                    <input type="submit" name="Редактировать" formmethod="post" formaction="/depart/update" value="Редактировать"/>
                </tr>
            </table>
        </form>
    </body>
</html>