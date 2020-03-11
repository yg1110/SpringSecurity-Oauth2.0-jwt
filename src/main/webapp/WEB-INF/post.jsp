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
		<div id="colorlib-blog">
			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="blog-entry animate-box col-pb-sm">
							<a href="blog.html" class="blog-img"><img src="/main/images/img-1.jpg" class="img-responsive" alt="HTML5 Bootstrap Template by colorlib.com"></a>
							<div class="desc">
								<h3><a href="blog.html">${post.title}</a></h3>
								<p>${post.content}</p>
								<p class="tags">
									<a href="#">Fashion</a>
									<a href="#">Beauty</a>
									<a href="#">Health</a>
									<a href="#">BLog</a>
									<a href="#">Travel</a>
									<a href="#">Summer</a>
								</p>
								<div class="author text-center">
									<a href="about.html" class="author-img" style="background-image: url(/main/images/about.jpg);"></a>
									<h3><a href="about.html">Vanessa Morgan</a></h3>
									<p>Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane.</p>
									<p class="colorlib-social-icons">
										<a href="#"><i class="icon-facebook4"></i></a>
										<a href="#"><i class="icon-twitter3"></i></a>
										<a href="#"><i class="icon-googleplus"></i></a>
										<a href="#"><i class="icon-dribbble2"></i></a>
									</p>
								</div>
								<div class="row">
									<div class="col-md-6 text-left">
										<a href="#" class="nav-next-prev">
											<span><i class="icon-arrow-left3"></i> Previous</span>
											<h2>30 Places you want to visits</h2>
										</a>
									</div>
									<div class="col-md-6 text-right">
										<a href="#" class="nav-next-prev">
											<span>Next <i class="icon-arrow-right3"></i></span>
											<h2>New Arrival Jeans Original For Fashion</h2>
										</a>
									</div>
								</div>
							</div>
						</div>

						<div class="comment-box animate-box">
							<h2 class="colorlib-heading-2">3 Comments</h2>
							<div class="comment-post">
								<div class="user" style="background-image: url(/main/images/about.jpg);"></div>
								<div class="desc">
									<h3>Stephen Brent <span>Commented 5 days ago</span></h3>
									<p>A small river named Duden flows by their place and supplies. Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane.</p>
								</div>
							</div>
							<div class="comment-post">
								<div class="user" style="background-image: url(/main/images/about-2.jpg);"></div>
								<div class="desc">
									<h3>Stephen Brent <span>Commented 5 days ago</span></h3>
									<p>A small river named Duden flows by their place and supplies. Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane.</p>
								</div>
							</div>
							<div class="comment-post">
								<div class="user" style="background-image: url(/main/images/about.jpg);"></div>
								<div class="desc">
									<h3>Stephen Brent <span>Commented 5 days ago</span></h3>
									<p>A small river named Duden flows by their place and supplies. Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane.</p>
								</div>
							</div>
						</div>
						<div class="comment-area animate-box">
							<h2 class="colorlib-heading-2">Leave a comment</h2>
							<form action="#">
								<div class="row form-group">
									<div class="col-md-6">
										<input type="text" id="fname" class="form-control" placeholder="Your firstname">
									</div>
									<div class="col-md-6">
										<input type="text" id="lname" class="form-control" placeholder="Your lastname">
									</div>
								</div>

								<div class="row form-group">
									<div class="col-md-12">
										<input type="text" id="email" class="form-control" placeholder="Your email address">
									</div>
								</div>

								<div class="row form-group">
									<div class="col-md-12">
										<input type="text" id="subject" class="form-control" placeholder="Your subject of this message">
									</div>
								</div>

								<div class="row form-group">
									<div class="col-md-12">
										<textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="Say something about us"></textarea>
									</div>
								</div>
								<div class="form-group">
									<input type="submit" value="Post Comment" class="btn btn-primary">
								</div>

							</form>	
						</div>
					</div>
				</div>
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