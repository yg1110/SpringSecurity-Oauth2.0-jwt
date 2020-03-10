<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

</head>

<body>
	<nav id="colorlib-main-nav" role="navigation">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle active"><i></i></a>
		<div class="colorlib-table">
			<div class="colorlib-table-cell">
				<div class="row">
					<div class="col-md-12">
						<ul>
							<li class="active"><a href="/user/login/result">Home</a></li>
							<li><a href="/blog/postlist">Blog</a></li>
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

		<div id="colorlib-contact">
			<div class="container">
				<div class="row text-center">
					<h2 class="bold">Contact</h2>
				</div>
				<div class="row">
					<div
						class="col-md-12 col-md-offset-0 text-center animate-box intro-heading">
						<span>Contact</span>
						<h2>Contact Me</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="rotate">
							<h2 class="heading">Contact</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-md-offset-0">
						<form method="post" action="/write" id="post_form">
							<div class="form-group">
								<input type="text" name="title" id="title" class="form-control"
									placeholder="제목을 입력하세요">
							</div>
							<textarea name="content" id="content"></textarea>
							<script>
								CKEDITOR.replace("content", {
									height : 500
								});
							</script>
							<br>
							<button type="button" class="btn btn-primary btn-outline"
								style="float: right" id='syn_btn'>동 기 작 성 완 료</button>
							<button type="button" class="btn btn-primary btn-outline"
								style="float: right" id='asyn_btn'>비 동 기 작 성 완 료</button>
						</form>
					</div>
				</div>

			</div>
		</div>

		<footer>
			<div id="footer">
				<div class="row">
					<div class="col-md-12 text-center">
						<p>
							&copy; Copyright &copy;
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
		$('#asyn_btn').on('click', function() {
			var data = {"title": $('#title').val(), "content": CKEDITOR.instances.content.getData()}
			
			$.ajax({
				url : "/restwrite",
				type : "POST",
				data : data,
				error : function(e) {
					console.log(e);
				}
			});
		});
		$('#syn_btn').on('click', function() {
			$('#post_form').submit();
		});
	</script>

</body>

</html>