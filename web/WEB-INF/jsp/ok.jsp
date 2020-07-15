<%--
  Created by IntelliJ IDEA.
  User: wangqi26959
  Date: 2020-06-29
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>${message}</h1>
    <form action="/k/user" method="post">
        <label>用户名：</label><input type="text" name="username"><br/>
        <label>密码：</label><input id="pw" type="password" name="password"><input id="ck" type="checkbox" onclick="hideShowPsw()"/><br/>
        <input type="submit" value="登陆"/><input type="reset" value="重置"/>
    </form>
</body>
</html>
<script type="text/javascript">
    var password = document.getElementById("pw");
    var ck = document.getElementById("ck");
    function hideShowPsw(){
        if (password.type == "password") {
            password.type = "text";
        }else {
            password.type = "password";
        }
    }
</script>
