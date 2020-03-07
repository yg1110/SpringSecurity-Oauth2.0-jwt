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
					action="/signup" method="post" id="user_signup_form" name="user_signup_form">
					<span class="login100-form-title p-b-30"> Sign up With </span>

					<div class="p-t-10 p-b-10" style="width: 100%">
						<span class="txt1"> 이메일 </span>
					</div>
					<div class="col-8 wrap-input100 validate-input"
						id="validate-username" data-validate="Username is required">
						<input class="input100" type="text" name="username" id="username">
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
						data-validate="Password is required" style="width: 100%">
						<input class="input100" type="password" name="password"
							id="password"> <span class="focus-input100"></span>
					</div>

					<div class="p-t-13 p-b-9" style="width: 100%">
						<span class="txt1"> 비밀번호 확인 </span>
					</div>
					<div class="wrap-input100 validate-input"
						id="validate-passwordConfirm"
						data-validate="passwordConfirm is required" style="width: 100%">
						<input class="input100" type="password" name="passwordConfirm"
							id="passwordConfirm"> <span class="focus-input100"></span>
					</div>

					<div class="p-t-10 p-b-10" style="width: 100%">
						<span class="txt1"> 이름 </span>
					</div>
					<div class="wrap-input100 validate-input" style="width: 100%"
						data-validate="name is required">
						<input class="input100" type="text" name="name" id="name">
						<span class="focus-input100"></span>
					</div>
					
					<div class="validate-input" data-validate="passwordConfirm is required">
						<input class="input100" type="hidden" id="isAccountNonExpired"
							name="isAccountNonExpired" value="true">
					</div>

					<div class="validate-input" data-validate="passwordConfirm is required">
						<input class="input100" type="hidden"
							name="isAccountNonLocked" value="true">
					</div>
					
					<div class="validate-input" data-validate="passwordConfirm is required">
						<input class="input100" type="hidden"
							name="isCredentialsNonExpired" value="true">
					</div>
					
					<div class="validate-input" data-validate="passwordConfirm is required">
						<input class="input100" type="hidden"
							name="isEnabled" value="true">
					</div>
					
					<div class="validate-input" data-validate="passwordConfirm is required">
						<input class="input100" type="hidden"
							id="duplicate_button_flag" value="flase">
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn" onclick="user_signup()">가입하기</button>
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
	<script src="/login/js/main.js"></script>

	<script type="text/javascript">
		var yourDateToGo = new Date();
		yourDateToGo.setDate(yourDateToGo.getDate() + 1);
		var timeend = 180;

		function clock() {
			timeend--;
			console.log(timeend);
			var currentDate = new Date().getTime();
			var timeLeft = yourDateToGo - currentDate;

			var minutes = Math
					.floor((timeLeft % (1000 * 60 * 3)) / (1000 * 60));
			if (minutes < 10)
				minutes = "0" + minutes;

			var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);
			if (seconds < 10)
				seconds = "0" + seconds;

			document.getElementById("countdown").innerHTML = minutes + "m "
					+ seconds + "s";
			if (this.timeend === 0) {
				clearInterval(timing);
				document.getElementById("countdown").innerHTML = "It's over";
			}
		}

		function send_email() {
			timing = setInterval(this.clock, 1000); //var 선언을 안할시 전역변수 취급
		}

		// 이메일 중복 체크	
		$('#email_duplicate_check').on('click', function(e) {
			/* $("#validate-username").attr('data-validate', 'email xxxx'); */
			if($('#username').val() === ''){
				console.log($('#duplicate_button_flag').val());
				$('#duplicate_button_flag').attr('value', 'true');
				console.log($('#duplicate_button_flag').val());
			}
			else{
				console.log($('#duplicate_button_flag').val());
				$('#duplicate_button_flag').attr('value', 'true');
				console.log($('#duplicate_button_flag').val());
	
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
		})

		// 가입
		// 여기선 form이 이름
		function user_signup() {
			var password = document.user_signup_form.password;
			var passwordConfirm = document.user_signup_form.passwordConfirm;
			if (password.value !== passwordConfirm.value) {
				alert("입력하신 비밀번호가 다릅니다.");
				password.value = '';
				passwordConfirm.value = '';
			}
		}
	</script>

</body>
</html>