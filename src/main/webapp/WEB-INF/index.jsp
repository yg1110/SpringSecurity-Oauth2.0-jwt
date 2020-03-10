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
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Karla:400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Animate.css -->
<link rel="stylesheet" href="/main/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="/main/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="/main/css/bootstrap.css">
<!-- Owl Carousel -->
<link rel="stylesheet" href="/main/css/owl.carousel.min.css">
<link rel="stylesheet" href="/main/css/owl.theme.default.min.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="/main/css/magnific-popup.css">

<link rel="stylesheet" href="/main/css/style.css">


<!-- Modernizr JS -->
<script src="/main/js/modernizr-2.6.2.min.js"></script>

</head>

<body>

	<nav id="colorlib-main-nav" role="navigation">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle active"><i></i></a>
		<div class="colorlib-table">
			<div class="colorlib-table-cell">
				<div class="row">
					<div class="col-md-12">
						<ul>
							<sec:authorize access="isAuthenticated()">
								<sec:authentication property="principal" var="user" />
								<div>${user}님</div>
							</sec:authorize>
							<sec:authorize access="isAnonymous()">
								<li><a href="/user/loginPage">로그인</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<li><a href="/user/logout">로그아웃</a></li>
							</sec:authorize>
							<sec:authorize access="isAnonymous()">
								<li><a href="/user/signup">회원가입</a>
								<li>
							</sec:authorize>
							<sec:authorize
								access="hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')">
								<li><a href="/user/info">내정보</a>
								<li>
							</sec:authorize>
							<sec:authorize access="hasAuthority('ROLE_ADMIN')">
								<li><a href="/user/admin">admin</a></li>
							</sec:authorize>

							<li class="active"><a href="/user/login/result">Home</a></li>
							<li><a href="/post/list">Blog</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<div id="colorlib-page">
		<header>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="colorlib-navbar-brand">
							<a class="colorlib-logo" href="/user/login/result"><span>YG</span><span>1110</span></a>
						</div>
						<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
					</div>
				</div>
			</div>
		</header>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="user" />
			<c:choose>
				<c:when test="${user.certified != 'Y'}">					
					<div id="colorlib-about">
						<div class="container">
							<div class="row text-center">
								<h2 class="bold">certified</h2>
							</div>
							<div class="row">
								<div class="col-md-12 col-md-push-1 animate-box">
									<div class="about-desc">
										<div class="item">
											<h2>
												<span>certified</span>
											</h2>
										</div>
										<div class="desc">
											<div class="rotate">
												<h2 class="heading">certified</h2>
											</div>
											<h3>YG1110 BLOG 회원가입을 축하드립니다.</h3>
											<p>${user.name}님회원가입에 감사드립니다.
											<p>
											<p>모든 서비스를 이용하기 위해 이메일 인증을 완료하여 주세요.</p>
											<hr>
											<form id="email_form">
												<input type="hidden" name="certified" value="${user.certified}">
												<input type="hidden" name="username" value="${user.username}">
												<input type="hidden" name="name" value="${user.name}">												
											</form>
											<p>
												<a class="btn btn-primary btn-outline"
													id="email_send_buttton">이메일 인증하기</a>
											</p>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div id="colorlib-services">
						<div class="container">
							<div class="row text-center">
								<h2 class="bold">Services</h2>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="services-flex">
										<div class="one-third">
											<div class="row">
												<div
													class="col-md-12 col-md-offset-0 animate-box intro-heading">
													<span>My Services</span>
													<h2>Here Are Some of My Skills</h2>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="rotate">
														<h2 class="heading">Services</h2>
													</div>
												</div>
												<div class="col-md-6">
													<div class="services animate-box">
														<h3>1 - Back End Development</h3>
														<ul>
															<li>Spring</li>
															<li><del>Node.js</del></li>
															<li><del>Django</del></li>
														</ul>
													</div>
													<div class="services animate-box">
														<h3>3 - Database</h3>
														<ul>
															<li>Mysql</li>
															<li>MongoDB</li>
															<li><del>Redis</del></li>
														</ul>
													</div>
												</div>
												<div class="col-md-6">
													<div class="services animate-box">
														<h3>2 - Front End Development</h3>
														<ul>
															<li>HTML / CSS</li>
															<li>JavaScript &amp; Jquery</li>
															<li>Vue.js &amp; Vuetify</li>
															<li>bootstap</li>
														</ul>
													</div>
													<div class="services animate-box">
														<h3>4 - ETC</h3>
														<ul>
															<li>AWS</li>
															<li>Github</li>
														</ul>
													</div>
												</div>
											</div>
										</div>
										<div class="one-forth services-img"
											style="background-image: url(/main/images/services-img-1.jpg);">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

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
							<div class="row animate-box">
								<div class="owl-carousel1">
									<div class="item">
										<div class="col-md-12">
											<div class="article">
												<a href="blog.html" class="blog-img"> <img
													class="img-responsive" src="/main/images/img-1.jpg"
													alt="html5 bootstrap by colorlib.com">
													<div class="overlay"></div>
													<div class="link">
														<h2>
															<span class="read">Read more</span>
														</h2>
													</div>
												</a>
												<div class="desc">
													<span class="meta">15, Feb 2018</span>
													<h2>
														<a href="#">A Japanese Constellation</a>
													</h2>
													<p>When she reached the first hills of the Italic
														Mountains, she had a last view back on the skyline of her
														hometown Bookmarksgrove</p>
												</div>
											</div>
										</div>
									</div>
									<div class="item">
										<div class="col-md-12">
											<div class="article">
												<a href="blog.html" class="blog-img"> <img
													class="img-responsive" src="/main/images/img-2.jpg"
													alt="html5 bootstrap by colorlib.com">
													<div class="overlay"></div>
													<div class="link">
														<span class="read">Read more
															</h2>
													</div>
												</a>
												<div class="desc">
													<span class="meta">15, Feb 2018</span>
													<h2>
														<a href="blog.html">A Japanese Constellation</a>
													</h2>
													<p>When she reached the first hills of the Italic
														Mountains, she had a last view back on the skyline of her
														hometown Bookmarksgrove</p>
												</div>
											</div>
										</div>
									</div>
									<div class="item">
										<div class="col-md-12">
											<div class="article">
												<a href="blog.html" class="blog-img"> <img
													class="img-responsive" src="/main/images/img-3.jpg"
													alt="html5 bootstrap by colorlib.com">
													<div class="overlay"></div>
													<div class="link">
														<span class="read">Read more
															</h2>
													</div>
												</a>
												<div class="desc">
													<span class="meta">15, Feb 2018</span>
													<h2>
														<a href="blog.html">A Japanese Constellation</a>
													</h2>
													<p>When she reached the first hills of the Italic
														Mountains, she had a last view back on the skyline of her
														hometown Bookmarksgrove</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</sec:authorize>

		<footer>
			<div id="footer">
				<div class="row">
					<div class="col-md-12 text-center">
						<p>
							&copy;
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
						</p>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<!-- jQuery -->
	<script src="/main/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="/main/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="/main/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="/main/js/jquery.waypoints.min.js"></script>
	<!-- Owl Carousel -->
	<script src="/main/js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="/main/js/jquery.magnific-popup.min.js"></script>
	<script src="/main/js/magnific-popup-options.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="/main/js/main.js"></script>

	<script type="text/javascript">
		$('#email_send_buttton').on(
				'click',
				function() {
					$.ajax({
						url : "/user/email/send",
						type : "GET",
						data : $("#email_form").serialize(),
						success : function(data) {
							alert("이메일이 전송되었습니다.")
						},
						error : function(e) {
							console.log(e);
						}
					});
 			});
	</script>
</body>

</html>