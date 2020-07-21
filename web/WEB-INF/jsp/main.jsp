<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <h1>登陆成功！</h1><br/>
    <a href="/user/index"> <input type="button" value="用户列表查看"/></a>

    <br/>
    <br/>
    <form  action="/user/upload" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="file" />
        <br />
        标题：<label>
        <input type="text" name="title" />
    </label>
        <br />
        <button type="submit">提交</button>
    </form>
    <br/>
    <br/>
    <c:forEach items="${fileNames}" var="name">
        <a href="/user/download?fileName=${name}" >${name}</a>
    </c:forEach>

</body>
</html>
