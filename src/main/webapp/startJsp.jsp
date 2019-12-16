<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 09.12.2019
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
    <h1>Начало работы</h1>
    <form name="startDepart">
        <table>
            <tr><input type="submit" value="К списку департаментов" formaction="/depart/select" formmethod="get"> </tr>
        </table>
    </form>
</body>
</html>
