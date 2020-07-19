<%--
  Created by IntelliJ IDEA.
  User: wangqi26959
  Date: 2020-06-29
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = "";
    String password = "";
    //获取当前站点的所有Cookie
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
        if ("username".equals(cookies[i].getName())) {
            username = cookies[i].getValue();
        } else if ("password".equals(cookies[i].getName())) {
            password = cookies[i].getValue();
        }
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>${message}</h1>
<form action="/k/login" method="post">
    <label>用户名：</label><input type="text" name="username" value="<%=username%>"><br/>
    <label>密码：</label><input id="pw" type="password" name="password" value="<%=password%>">
    <input id="ck" type="checkbox" onclick="hideShowPsw()"/><label>显示</label>
    <input id="rm" type="checkbox" name="remember"/><label>记住密码</label><br/>
    <input type="submit" value="登陆"/><input type="reset" value="重置"/>
</form>
</body>
</html>
<script type="text/javascript">
    var password = document.getElementById("pw");
    var ck = document.getElementById("ck");
    function hideShowPsw() {
        if (password.type == "password") {
            password.type = "text";
        } else {
            password.type = "password";
        }
    }
</script>
