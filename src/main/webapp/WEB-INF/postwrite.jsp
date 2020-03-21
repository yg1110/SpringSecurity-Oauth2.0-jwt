<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

</head>

<body>
	<%@ include file="etc/nav.jsp"%>
	
	<div id="colorlib-page">
	
		<%@ include file="etc/header.jsp"%>
	

		<div id="colorlib-contact">
			<div class="container">
				<div class="row text-center">
					<h2 class="bold">Post</h2>
				</div>
								
				<div class="row">
					<div
						class="col-md-12 col-md-offset-0 text-center animate-box intro-heading">
						<span>Post</span>
						<h2>Post</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="rotate">
							<h2 class="heading">Post</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-md-offset-0">
						<form method="post" action="/write" id="post_form" enctype="multipart/form-data" >
						<input type="hidden" name="username" value=${user.username} >
							<div class="form-group">
								<input type="text" name="title" id="title" class="form-control"
									placeholder="제목을 입력하세요">
							</div>
							<textarea name="content" id="content"></textarea>
							<script>
								CKEDITOR.replace("content", {
									height : 250
								});
							</script>
							<br>
							
							<input type="file" name="files">
							
							<button type="button" class="btn btn-primary btn-outline"
								style="float: right" id='syn_btn'>작 성 완 료</button>
						</form>
					</div>
				</div>

			</div>
		</div>
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

	<script type="text/javascript">
		$('#syn_btn').on('click', function() {
			$('#post_form').submit();
		});
	</script>

</body>

</html>