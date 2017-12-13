<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring学习第二章</title>
    <form action="<c:url value="/crackPassword.html"/>" method="post">
        用户名:
        <input type="text" name="userName">
        <br>
        <input type="submit" value="crack">
    </form>
</head>
</html>