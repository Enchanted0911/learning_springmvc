<%--
  Created by IntelliJ IDEA.
  User: Wu
  Date: 2021/4/10
  Time: 13:41
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
    <%--    解决相对路径循环访问出错问题，使用base标签     --%>
    <base href="<%=basePath%>"/>
</head>
<body>
<p>一个拦截器</p>
<form action="test/some.do" method="post">
    姓名 : <label>
    <input type="text" name="name"/>
</label> <br>
    姓名 : <label>
    <input type="text" name="age"/>
</label> <br>
    <input type="submit" value="提交请求" />
</form>
</body>
</html>
