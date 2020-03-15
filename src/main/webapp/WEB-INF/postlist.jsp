<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>YG1110 BLOG</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Karla:400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700"
	rel="stylesheet">

<link rel="stylesheet" href="/main/css/animate.css">
<link rel="stylesheet" href="/main/css/icomoon.css">
<link rel="stylesheet" href="/main/css/bootstrap.css">
<link rel="stylesheet" href="/main/css/owl.carousel.min.css">
<link rel="stylesheet" href="/main/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/main/css/magnific-popup.css">
<link rel="stylesheet" href="/main/css/style.css">

</head>

<body>
	<%@ include file="etc/nav.jsp"%>

	<div id="colorlib-page">
		<%@ include file="etc/header.jsp"%>

		<div id="colorlib-blog">
			<div class="container">
				<div class="row text-center">
					<h2 class="bold">Blog</h2>
				</div>
				<div class="row">
					<div
						class="col-md-12 col-md-offset-0 text-center animate-box intro-heading">
						<span>Blog</span>
						<h2>Read Our Case</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="rotate">
							<h2 class="heading">Our Blog</h2>
						</div>
					</div>
				</div>
				<a href="/post/write" class="btn btn-primary btn-outline"
					style="float: right">글 쓰 기</a> <br> <br>
				<c:forEach items="${post}" var="p" varStatus="status">
					<c:if test="${status.count%3==0}"><div class="row"></c:if>					
						<div class="col-md-4">
							<div class="article animate-box">
								${status.count } <a href="/post/single/${p.post_id}"
									class="blog-img"> <img class="img-responsive"
									src="${p.thumbnail}" alt="html5 bootstrap by colorlib.com">
									<div class="overlay"></div>
									<div class="link">
										<span class="read">Read more 
									</div>
								</a>
								<div class="desc">
									<span class="meta">${p.date}</span> <a href="/post/single/${p.post_id}">${p.title}</a>
									</h2>
									<p>${p.excerpt}</p>
								</div>
							</div>
						</div>
					<c:if test="${status.count%3==0}"></div></c:if>					
				</c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="etc/footer.jsp"%>

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