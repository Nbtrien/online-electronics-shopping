<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
		<label for="tab-1" class="tab">Login</label> <input id="tab-2"
			type="radio" name="tab" class="for-pwd"> <label for="tab-2"
			class="tab">Forgot Password</label>
		<div class="login-form">
			<div class="sign-in-htm">
				<form action="<c:url value='../auth/login'/>" method="post">
					<div class="group">
						<label for="userName" class="label">Username or Email</label> <input
							id="userName" name="userName" type="text" class="input">
					</div>
					<div class="group">
						<label for="passWord" class="label">Password</label> <input
							id="passWord" name="passWord" type="password" class="input"
							data-type="password">
					</div>
					<div class="group">
						<input type="submit" class="button" value="Sign In">
					</div>
					<div>
						<span class="to-reg">Don't have an account? <a
							href="../auth/register">Register</a></span>
					</div>
					<div class="hr"></div>
				</form>
			</div>
			<div class="for-pwd-htm">
				<form>
					<div class="group">
						<label for="user" class="label">Username or Email</label> <input
							id="user" type="text" class="input">
					</div>
					<div class="group">
						<input type="submit" class="button" value="Reset Password">
					</div>
					<div class="hr"></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>