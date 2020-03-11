<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<sec:authentication property="principal" var="user" />
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
						<p>${user.name}님회원가입에감사드립니다.
						<p>
						<p>모든 서비스를 이용하기 위해 이메일 인증을 완료하여 주세요.</p>
						<hr>
						<form id="email_form">
							<input type="hidden" name="certified" value="${user.certified}">
							<input type="hidden" name="username" value="${user.username}">
							<input type="hidden" name="name" value="${user.name}">
						</form>
						<p>
							<a class="btn btn-primary btn-outline" id="email_send_buttton">이메일
								인증하기</a>
						</p>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('#email_send_buttton').on('click', function() {
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