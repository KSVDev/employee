<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 08.12.2019
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h1>Hi, Sergey!</h1>
    <p>
        <%@ page import="java.util.Date" %>
        <%
            for (int i = 0; i <= 10; i++){
                Date date = new Date();
                out.println("<p> DateTime: " + date + ". Cycle: " + i + "</p>");
            }
        %>
    </p>
</body>
</html>
