<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:directive.page import="org.springframework.web.context.support.ServletContextResource"/>
<jsp:directive.page import="org.springframework.core.io.Resource"/>
<jsp:directive.page import="org.springframework.web.util.WebUtils"/>

<html>
<head>
    <body>
welcome yoyo~yo~yo~
<c:if test="${!empty car}">
    <c:out value="${car.brand}"/>
</c:if>
<c:if test="${!empty boss}">
    <c:out value="${boss.name}"/> has a car named
    <c:out value="${boss.car.brand}"/>
</c:if>
<br>
<%
    Resource res3 = new ServletContextResource(application, "/WEB-INF/classes/conf/file1.txt");
    out.print(res3.getFilename() + "<br/>");
    out.print(WebUtils.getTempDir(application).getAbsolutePath());
%>
</body>
</head>
</html>