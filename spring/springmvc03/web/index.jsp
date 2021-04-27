<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/28
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <a href="handle01?username=tomcat">默认获取参数的值</a><br>
    <a href="handle02?user=tomcat">@RequestParam获取参数的值</a><br>
    <a href="handle03">原生api获取请求域的值</a><br>
    <form action="book02" method="post">
      书名：<input type="text" name="bookName"><br>
      作者：<input type="text" name="author"><br>
      价格：<input type="text" name="price"><br>
      库存：<input type="text" name="stock"><br>
      销量：<input type="text" name="sales"><br>
      <hr>
      省份：<input type="text" name="adress.province"><br>
      城市：<input type="text" name="adress.city"><br>
      街道：<input type="text" name="adress.street"><br>
      <input type="submit" value="提交">
    </form><br>
  </body>
</html>
