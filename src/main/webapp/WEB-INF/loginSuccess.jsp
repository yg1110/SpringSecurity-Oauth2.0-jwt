<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en" xmlns:sec="" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1>로그인 성공!!</h1>
	<hr>
	<p>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="user" />
			<div>${user}님</div>
		</sec:authorize>
	</p>
    <sec:authorize access="hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')"><a href="/user/info">내정보</a></sec:authorize><br>
    <sec:authorize access="hasAuthority('ROLE_USER')"><a href="/user/admin">admin</a></sec:authorize><br>
	
	<a href="/">메인으로 이동</a>
</body>
</html>