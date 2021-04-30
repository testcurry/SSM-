<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/28
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<h1>员工添加</h1>
<%
pageContext.setAttribute("cpt",request.getContextPath());
%>
<%--springmvc提供的表单标签--%>
<form:form action="${cpt}/addEmp" modelAttribute="employee" method="post">
    lastName:<form:input path="lastName"></form:input><br>
    email:<form:input path="email"></form:input><br>
    gender:<br>
    男：<form:radiobutton path="gender" value="1"></form:radiobutton><br>
    女：<form:radiobutton path="gender" value="0"></form:radiobutton><br>
    dept:<br>
    <form:select path="department.id" items="${depts}"
                 itemLabel="departmentName" itemValue="id"></form:select><br>
    <input type="submit" value="保存"><br>
</form:form>



<%--原生的表单--%>
    <%--<form action="">

        lastName:<input type="text" name="lastName"/><br>
        email:<input type="text" name="email"/><br>
        gender:<br>
        男：<input type="radio" name="gender" value="1"/><br>
        女：<input type="radio" name="gender" value="0"/><br>
        lastName:<input type="text" name="lastName"/><br>
        lastName:<input type="text" name="lastName"/><br>
        dept：
        <select name="department.id">
           <c:forEach items="${depts}" var="deptItem">
               <option value="${deptItem.id}">${deptItem.departmentName}</option>
           </c:forEach>
        </select>
        <input type="submit" value="添加">
    </form>--%>
</body>
</html>
