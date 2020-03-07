<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<title>YG1110 BLOG</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/login/css/util.css">
<link rel="stylesheet" type="text/css" href="/login/css/main.css">
<!--===============================================================================================-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="card wrap-login100 p-l-50 p-r-50 p-t-50 p-b-50">
				<form class="login100-form validate-form flex-sb flex-w"
					onsubmit="return false" name="user_signup_form"
					id="user_signup_form">
					<span class="login100-form-title p-b-30"> Sign up With </span>

					<div class="p-t-10 p-b-10" style="width: 100%">
						<span class="txt1"> 이메일 </span>
					</div>
					<div class="col-8 wrap-input100 validate-input"
					id="validate-email"
						data-validate="이메일을 입력해주세요.">
						<input class="input100" type="email" name="username" id="username">
						<span class="focus-input100"></span>
					</div>
					<div class="col-4">
						<button class="login100-form-btn" id="email_duplicate_check">
							중복<br>확인
						</button>
					</div>

					<div class="p-t-13 p-b-9" style="width: 100%">
						<span class="txt1"> 비밀번호 </span>
					</div>
					<div class="wrap-input100 validate-input" id="validate-password"
						data-validate="비밀번호를 입력해주세요." style="width: 100%">
						<input class="input100" type="password" name="password"
							id="password"> <span class="focus-input100"></span>
					</div>

					<div class="p-t-13 p-b-9" style="width: 100%">
						<span class="txt1"> 비밀번호 확인 </span>
					</div>
					<div class="wrap-input100 validate-input"
						id="validate-passwordConfirm" data-validate="비밀번호를 입력해주세요."
						style="width: 100%">
						<input class="input100" type="password" name="passwordConfirm"
							id="passwordConfirm"> <span class="focus-input100"></span>
					</div>

					<div class="p-t-10 p-b-10" style="width: 100%">
						<span class="txt1"> 이름 </span>
					</div>
					<div class="wrap-input100 validate-input" style="width: 100%"
						data-validate="이름을 입력해주세요.">
						<input class="input100" type="text" name="name" id="name">
						<span class="focus-input100"></span>
					</div>
					<!-- <input type="hidden" name="isAccountNonExpired" value="true">
					<input type="hidden" name="isAccountNonLocked" value="true">
					<input type="hidden" name="isCredentialsNonExpired" value="true">
					<input type="hidden" name="isEnabled" value="true"> -->

					<div class="container-login100-form-btn m-t-70">
						<button class="login100-form-btn" id="user_signup_button">가입하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/bootstrap/js/popper.js"></script>
	<script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->

	<script type="text/javascript">
		// 이메일 중복 체크	
		var input = $('.validate-input .input100');

		$('#email_duplicate_check').on('click', function() {
			if (validate(input[0]) == false) {
				showValidate(input[0]);
			}
			else{
				$.ajax({
					url : "/user/signup/email_duplicate_check",
					type : "POST",
					data : $("#user_signup_form").serialize(),
					success : function(data) {
						console.log(data);
						if(data === true){
							$('#email_duplicate_check').attr('disabled', 'disabled');
							$('#email_duplicate_check').html('사용<br>가능');
							alert("사용이 가능한 이메일입니다.");
						}
						else{
							alert("이미 가입된 이메일이 존재합니다.");
						}
					},
					error : function(e) {
						console.log(e);
					}
				});
			}			
		});
		
		$('#user_signup_button').on('click', function() {
			$("#validate-password").attr('data-validate', '패스워드를 입력해주세요.');
			$("#validate-passwordConfirm").attr('data-validate', '패스워드를 입력해주세요.');

			// 공백검사
			for (var i = 0; i < input.length; i++) {
				if (validate(input[i]) == false) {
					showValidate(input[i]);
				}
			}
			
			// 패스워드 일치 검사
			var password = document.user_signup_form.password;
			var passwordConfirm = document.user_signup_form.passwordConfirm;
			if (password.value !== passwordConfirm.value) {
				$("#validate-password").attr('data-validate', '패스워드가 일치하지 않습니다.');
				$("#validate-passwordConfirm").attr('data-validate', '패스워드가 일치하지 않습니다.');
				showValidate(input[1]);
				showValidate(input[2]);
			}
			else{
				var form = document.forms['user_signup_form'];
				form.action = '/signup';
				form.method = 'post';
				form.submit();
			}
		});

		function validate(input) {
			if ($(input).attr('type') == 'email') {
				if ($(input)
						.val()
						.trim()
						.match(
								/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
					$("#validate-email").attr('data-validate', '이메일 형식이 맞지 않습니다.');
					return false;
				}
			} else {
				if ($(input).val().trim() == '') {
					return false;
				}
			}
		}
		
		function showValidate(input) {
			var thisAlert = $(input).parent();

			$(thisAlert).addClass('alert-validate');
		}
		
		function hideValidate(input) {
			var thisAlert = $(input).parent();

			$(thisAlert).removeClass('alert-validate');
		}
		
		$('.validate-form .input100').each(function() {
			$(this).focus(function() {
				hideValidate(this);
			});
		});
	</script>

</body>
</html>