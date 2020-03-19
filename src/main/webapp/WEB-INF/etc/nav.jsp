<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<nav id="colorlib-main-nav" role="navigation">
	<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle active"><i></i></a>
	<div class="colorlib-table">
		<div class="colorlib-table-cell">
			<div class="row">
				<div class="col-md-12">
					<ul>
						<sec:authorize access="isAuthenticated()">
							<sec:authentication property="principal" var="user" />
							<div>${user.name}님</div>
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