<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div id="header">
		<div class="container-fluid fl">
			<div class="brand">
				<a href="./Admin"><img class="logo" src="<c:url value='/assets/images/logo.png' />"></a>	
			</div>
			<div class="sname">
				<a href="admin.php"><span class="full_name">${userLogin.userName}</span></a>
				<span>|</span>
	         	<a class="m" href="Admin/Login/Logout" onclick="return CheckLogout()">
	         		<i class="fas fa-fw fa-sign-out-alt"></i>
	         		<span>Logout</span> 
	         	</a>
			</div>
		</div>		
	</div>
</body>
</html>