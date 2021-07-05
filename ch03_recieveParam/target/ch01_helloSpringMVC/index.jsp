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
</head>
<body>
    <p>提交参数给controller</p>
    <form action="test/receiveProperty.do" method="post">
        姓名 <input type="text" name="name" /> <br>
        年龄 <input type="text" name="age" /> <br>
        <input type="submit" value="提交" />
    </form>

    <br><br><br>
    <p>--------------------------------------------------------</p>
    <p>请求参数名和处理器参数名不一样</p>
    <form action="test/receiveParam.do" method="post">
        姓名 <input type="text" name="rName" /> <br>
        年龄 <input type="text" name="rAge" /> <br>
        <input type="submit" value="提交" />
    </form>


    <br><br><br>
    <p>--------------------------------------------------------</p>
    <p>使用java对象接收请求参数</p>
    <form action="test/receiveObject.do" method="post">
        姓名 <input type="text" name="Name" /> <br>
        年龄 <input type="text" name="Age" /> <br>
        <input type="submit" value="提交" />
    </form>

</body>
</html>
