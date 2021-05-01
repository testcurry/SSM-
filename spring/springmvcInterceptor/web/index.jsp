<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/5/1
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <%
    pageContext.setAttribute("cpt",request.getContextPath());
    %>
  </head>
  <body>
    <a href="${cpt}/handle01?i=10">test01hhh哈哈哈哈</a><br>
    <a href="${cpt}/handle02?username=admin">handle02</a><br>
    <a href="${cpt}/handle03">handle03</a><br>
    <a href="${cpt}/handle04">handle04</a><br>
  </body>
</html>
