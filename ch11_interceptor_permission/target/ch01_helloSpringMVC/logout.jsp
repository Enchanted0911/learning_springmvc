<%--
  Created by IntelliJ IDEA.
  User: Wu
  Date: 2021/4/13
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
退出系统
<%
    session.removeAttribute("name");
%>
</body>
</html>
