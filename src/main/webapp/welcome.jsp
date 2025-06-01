<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/31/2025
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@  page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>welcome page</title>
</head>
<body>
<h1>Login successfully</h1>
<%=session.getAttribute("emailFromRequest")%>
</body>
</html>
