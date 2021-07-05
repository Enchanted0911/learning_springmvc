<%--
  Created by IntelliJ IDEA.
  User: Wu
  Date: 2021/4/10
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    解决相对路径循环访问出错问题，使用base标签     --%>
    <base href="http://localhost:8080/myWeb/" />
</head>
<body>
<p>第一个mvc项目</p>
<%--    href 还可以使用 href="${pageContext.request.contextPath}/test/some.do}"  --%>
<p><a href="test/some.do">发起some.do请求(GET)</a></p>
<form action="test/some.do" method="post">
    <input type="submit" value="post请求some.do"/>
</form>
</body>
</html>
