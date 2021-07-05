<%--
  Created by IntelliJ IDEA.
  User: Wu
  Date: 2021/4/12
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 只针对当前页面有效， 有必要需要在每个页面加上这段代码
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>" />
</head>
<body>
<div align="center">
    <p>SSM整合例子</p>
    <img src="static/img/benchi.jpg"  alt="图片说明"/>
    <table>
        <tr>
            <td><a href="addStudent.jsp">注册学生</a></td>
        </tr>
        <tr>
            <td><a href="queryStudent.jsp">查询学生</a></td>
        </tr>
    </table>
</div>
</body>
</html>
