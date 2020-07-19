<%@ page import="top.king.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.databind.util.JSONPObject" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %><%--
  Created by IntelliJ IDEA.
  User: wangqi26959
  Date: 2020-07-19
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1">
    <tr>
        <td><input type="button" value="新增" onclick="add()"/></td>
    </tr>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>motto</td>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("user");
        ObjectMapper om = new ObjectMapper();
        for (User user : users) {%>
    <tr>
        <td><%=user.getUserId() %>
        </td>
        <td><%=user.getUsername() %>
        </td>
        <td><%=user.getPassword()%>
        </td>
        <td><%=user.getMotto() %>
        </td>
        <td><input type="button" value="删除" href="javascript:void(0)" onclick="del('<%= user.getUserId() %>')"/></td>
        <td><input type="button" value="修改" href="javascript:void(0)" onclick="modify('<%= user.getUserId() %>')"/></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
<script type="text/javascript">
    function modify(userid) {
        var user = {
            "userId":userid
        };
        user.username="test";
        var xhr = new XMLHttpRequest();
        xhr.timeout = 30000;
        xhr.ontimeout = function (event) {
            alert("请求超时！");
        };
        xhr.open('POST', '/user/update');
        xhr.setRequestHeader("content-type","application/json");
        var json = JSON.stringify(user);
        xhr.send(json);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                location.reload();
            }
        }
    }
    function del(count) {
        var xhr = new XMLHttpRequest();
        xhr.timeout = 30000;
        xhr.ontimeout = function (event) {
            alert("请求超时！");
        };
        xhr.open('POST', '/user/delete');
        xhr.setRequestHeader("content-type","application/x-www-form-urlencoded;charset=UTF-8");
        xhr.send("primaryKey="+count);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                location.reload();
            }
        }
    }

</script>
