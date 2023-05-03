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
		<label for="tab-1" class="tab">Register</label> <input id="tab-2"
			type="radio" name="tab" class="for-pwd"> <label for="tab-2"
			class="tab"></label>
		<div class="login-form">
			<div class="sign-in-htm register-htm">
				<form action="<c:url value='../auth/register'/>" method="post">

					<div class="group">
						<label for="userName" class="label">Username</label> <input id="userName"
							type="text" name="userName" class="input" placeholder="Username">
					</div>

					<div class="group-flex">
						<div class="group">
							<label for="firstName" class="label">First Name</label> <input
								id="firstName" name="firstName" type="text" class="input"
								placeholder="First Name">
						</div>
						<div class="group">
							<label for="lastName" class="label">Last Name</label> <input
								id="lastName" name="lastName" type="text" class="input"
								placeholder="Last Name">
						</div>
					</div>
					<div class="group">
						<label for="email" class="label">Email</label> <input id="email"
							name="email" type="text" class="input" placeholder="Email">
					</div>
					<div class="group">
						<label for="address" class="label">Address</label> <input
							id="address" name="address" type="text" class="input"
							placeholder="Address">
					</div>
					<div class="group">
						<label for="phoneNumber" class="label">Phone number</label> <input
							id="phoneNumber" name="phoneNumber" type="number" class="input"
							placeholder="Phone number">
					</div>
					<div class="group">
						<label for="passWord" class="label">Password</label> <input
							id="passWord" name="passWord" type="password" class="input"
							data-type="password" placeholder="Password">
					</div>
					<div class="group">
						<input type="submit" class="button" value="Register">
					</div>
					<div>
						<span class="to-reg">Already have an account? <a
							href="../auth/login">Login</a></span>
					</div>
					<div class="hr"></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>