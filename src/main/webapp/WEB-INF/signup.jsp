<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
</head>
<body>
    <h1>회원 가입</h1>
    <hr>
	<form action="/user/signup" method="post">
        <input type="text" name="username" placeholder="이메일 입력해주세요">
        <input type="password" name="password" placeholder="비밀번호">
        <input type="text" name="name" placeholder="이름">
        <input type="hidden" name="isAccountNonExpired" value="true">
        <input type="hidden" name="isAccountNonLocked" value="true">
        <input type="hidden" name="isCredentialsNonExpired" value="true">
        <input type="hidden" name="isEnabled" value="true">
        <button type="submit">가입하기</button>
    </form>
</body>
</html>