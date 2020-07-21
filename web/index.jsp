<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>${message}</h1>
<form action="/k/login" method="post">
  <label>用户名：</label><input type="text" name="username" value=""><br/>
  <label>密码：</label><input id="pw" type="password" name="password" value="">
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
