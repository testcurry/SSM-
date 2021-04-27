<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/28
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="book/2">查询图书</a><br>

  <form action="book/1" method="post">
    <input type="submit" value="新增图书">
  </form><br>
  <form action="book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="修改图书">
  </form><br>
  <form action="book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除图书">
  </form><br>

  </body>
</html>
