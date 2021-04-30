<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/30
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <%
    pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
    <form action="${ctp}/uploadMul" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"><br>
        用户头像：<input type="file" name="headImg"><br>
        用户头像：<input type="file" name="headImg"><br>
        用户头像：<input type="file" name="headImg"><br>
        用户头像：<input type="file" name="headImg"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
