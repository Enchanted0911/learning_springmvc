<%--
  Created by IntelliJ IDEA.
  User: Wu
  Date: 2021/4/12
  Time: 19:57
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
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<%--    <script type="text/javascript" src="static/js/jquery-3.6.0.js"></script>--%>
    <script type="text/javascript">
        $(function () {
            loadStudentData();
            $("#btnLoader").click(function () {
                loadStudentData();
            })
        })
        function loadStudentData() {
            $.ajax({
                url : "student/queryStudent.do",
                type : "get",
                dataType : "json",
                success : function (data) {
                    $("#info").html("");
                    $.each(data, function (i, n) {
                        $("#info").append("<tr>")
                            .append("<td>" + n.id + "</td>")
                            .append("<td>" + n.name + "</td>")
                            .append("<td>" + n.age + "</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="info">

        </tbody>
    </table>
    <input type="button" id="btnLoader" value="查询数据">
</div>
</body>
</html>
