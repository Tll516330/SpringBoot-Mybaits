<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有</title>
</head>
<body>
    <h1>查询所有</h1>
    <c:forEach items="${list}" var="account">
        <h3>${account.name}:${account.money}</h3>
    </c:forEach>

</body>
</html>
