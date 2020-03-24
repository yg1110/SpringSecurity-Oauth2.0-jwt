<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>YG1110 BLOG</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Karla:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700" rel="stylesheet">

<link rel="stylesheet" href="/main/css/animate.css">
<link rel="stylesheet" href="/main/css/icomoon.css">
<link rel="stylesheet" href="/main/css/bootstrap.css">
<link rel="stylesheet" href="/main/css/owl.carousel.min.css">
<link rel="stylesheet" href="/main/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/main/css/magnific-popup.css">
<link rel="stylesheet" href="/main/css/style.css">

<script src="/main/js/modernizr-2.6.2.min.js"></script>

</head>

<body>
	<%@ include file="etc/nav.jsp"%>

	<div id="colorlib-page">
		<%@ include file="etc/header.jsp"%>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="user" />
			<%@ include file="main/certified_main.jsp"%>
			
			<%-- <c:choose>
				<c:when test="${user.certified != 'Y'}">
					<%@ include file="main/uncertified_main.jsp"%>
				</c:when>

				<c:otherwise>
					<%@ include file="main/certified_main.jsp"%>
				</c:otherwise>
			</c:choose> --%>
		</sec:authorize>
		<%@ include file="etc/footer.jsp"%>
	</div>

	<script src="/main/js/jquery.min.js"></script>
	<script src="/main/js/jquery.easing.1.3.js"></script>
	<script src="/main/js/bootstrap.min.js"></script>
	<script src="/main/js/jquery.waypoints.min.js"></script>
	<script src="/main/js/owl.carousel.min.js"></script>
	<script src="/main/js/jquery.magnific-popup.min.js"></script>
	<script src="/main/js/magnific-popup-options.js"></script>
	<script src="/main/js/main.js"></script>

</body>

</html>