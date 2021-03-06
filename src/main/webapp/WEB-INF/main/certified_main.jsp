<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
							<div class="col-md-12 col-md-offset-0 animate-box intro-heading">
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
										<li>bootstrap</li>
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
				<h2>Read Our Blog</h2>
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
				<c:forEach items="${post}" var="p">
					<div class="item">
						<div class="col-md-12">
							<div class="article">
								<a href="/post/single/${p.post_id}" class="blog-img"> <img
									class="img-responsive" src="${p.thumbnail}"
									alt="html5 bootstrap by colorlib.com">
									<div class="overlay"></div>
									<div class="link">
										<h2>
											<span class="read">Read more</span>
										</h2>
									</div>
								</a>
								<div class="desc">
									<span class="meta">${p.date}</span>
									<h2>
										<a href="#">${p.title}</a>
									</h2>
									<p>${p.excerpt}</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>