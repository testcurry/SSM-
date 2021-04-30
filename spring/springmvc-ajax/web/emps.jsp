<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/30
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <%pageContext.setAttribute("cpt", request.getContextPath());%>
    <script type="text/javascript" src="script/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a:first").click(function () {

                $.ajax({
                        url: "${cpt}/getallajax",
                        type: "GET",
                        success: function (data) {
                            // console.log(data);
                            $.each(data,function () {
                                var empInfo=this.lastName+"-->"+this.gender;
                                $("div").append(empInfo+"</br>");
                            })
                        }
                    }
                );
                return false;
            });
        })
    </script>
</head>
<body>
    <%=new Date()%><br>
    <a href="${cpt}/getallajax">ajax获取所有员工</a>
<div>

</div>

</body>
</html>
