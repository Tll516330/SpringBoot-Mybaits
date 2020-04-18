<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="account/springmvc">查询所有</a>
    <h4>添加用户</h4>
    <form action="account/save" method="post">
        用户名：<input type="text" name="name"><br>
        金额：<input type="number" name="money"><br>
        <input type="submit" value="保存"><br>
    </form>
</body>
</html>
