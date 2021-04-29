<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/28
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <%pageContext.setAttribute("ctp", request.getContextPath());%>
    <script type="text/javascript" src="script/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {

            // alert("hhh");
            $(".delButton").click(function () {
                $("#delForm").attr("action",this.href);
                $("#delForm").submit();
                return false;
            });
        })
    </script>
</head>

<body>
<h1>员工列表</h1>
<table border="1" cellpadding="5px" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${requestScope.emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="${ctp}/emp/${emp.id}">edit</a>
            </td>
            <td>
                <a class="delButton" href="${ctp}/emp/${emp.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>

<a href="${ctp}/toaddpage">添加员工</a>

<form id="delForm" action="${ctp}/emp/${emp.id}" method="post">
    <input type="hidden" name="_method" value="delete">
<%--    <input type="submit" value="删除">--%>
</form>
</body>
</html>
