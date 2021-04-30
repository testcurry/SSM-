<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/29
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工</title>
    <%pageContext.setAttribute("cpt",request.getContextPath());%>
</head>
<body>
<h2>员工修改页面</h2>
 <form:form action="${cpt}/emp/${employee.id}"
            method="post" modelAttribute="employee">
     <input type="hidden" name="_method" value="put">
     <input type="hidden" name="id" value="${employee.id}">
     <%--     <input type="hidden" name="lastName" value="${employee.lastName}">--%>
     email:<form:input path="email"></form:input><br>
     gender:&nbsp;&nbsp;&nbsp;
     男：<form:radiobutton path="gender" value="1"></form:radiobutton>&nbsp;&nbsp;&nbsp;
     女：<form:radiobutton path="gender" value="0"></form:radiobutton><br>
     dept:
     <form:select path="department.id" items="${depts}"
                  itemLabel="departmentName" itemValue="id"></form:select><br>
     <input type="submit" value="修改">
 </form:form>
</body>
</html>
