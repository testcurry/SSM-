<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/30
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>requestBodyTest</title>
    <script type="text/javascript" src="script/jquery-3.5.1.min.js"></script>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <script type="text/javascript">
        $(function () {
            $("a:first").click(function () {
                var obj={"lastName":"张三","email":"test@qq.com","gender":"1"};
                // var obj = {lastName: "张三", email: "test@qq.com", gender: 0};
                var jsonObj=JSON.stringify(obj);
                $.ajax({
                    url: "${ctp}/testRequestBody",
                    type: "POST",
                    data: jsonObj,
                    contentType:"application/json",
                    success: function (data) {
                        alert(data);
                    }
                });
                return false;
            });
        })
    </script>
</head>
<body>
<form action="${ctp}/test02" method="post" enctype="multipart/form-data">
    用户名： <input name="username" value="tomcat"/><br>
    密码：<input name="password" value="123456"/><br>
    <input type="file" name="file">
    <input type="submit" value="提交"/><br>
</form>

<a href="${ctp}/testRequestBody">ajax发送json数据</a>
</body>
</html>
