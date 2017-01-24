<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppinkart home</title>
</head>
<body>
<%@ include file="./header.jsp" %>
<%@ include file="./product_menu.jsp" %>




<a href="login">login</a>
<br>
<a href="register">register</a>

<c:if test="${showLoginPage}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${showRegistrationPage}">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<p>welcome</p>
</body>
</html>