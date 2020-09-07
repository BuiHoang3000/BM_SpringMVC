<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<title>Login</title>
</head>
<body class="loginForm">
<div class="loginbox">
	<img src="/BM_SpringMVC/resources/image/avatar.jpg" class="avatar">
	<h1>ĐĂNG NHẬP</h1>
	<form:form action="/BM_SpringMVC/" method="post" modelAttribute="loginForm" autocomplete="off">
		<p>Tên đăng nhập</p>
		<form:input path="ps_Email" type="text"/>
		<p>Mật khẩu</p>
		<form:password path="ps_Password"/>
	    <p>${message}</p>
		<p><button type="submit">Đăng nhập</button></p>
	</form:form>
</div>
</body>
</html>