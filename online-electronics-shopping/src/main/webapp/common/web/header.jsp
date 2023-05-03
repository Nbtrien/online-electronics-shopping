<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href="<c:url value='/assets/web/css/menu-style.css' />"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="header">
		<div class="header">
			<div class="container-fluid fl">
				<div class="brand">
					<a href="../"><img class="log"
						src="<c:url value='/assets/web/imgs/logo.png' />"></a>
				</div>
				<div class="tk ">
					<input type="text" name="key_word" id="key_word" class="iptk"
						placeholder="Type something as name, category, ...">
					<button type="" class="bttk" id="bt_search">
						<i class="fa fa-search"></i>
					</button>
				</div>
				<div class="hd-top-item-container sn_xl">
					<c:if test="${not empty userLogin }">
						<div class="hd-item-wrapper">
							<a class="hd-item-link" href="../cart"> <i
								class="fas fa-shopping-cart"></i>
								<div class="hd-item-title">My Cart</div>
							</a> <a class="hd-item-link" href="../orders"> <i
								class="fas fa-money-check"></i>
								<div class="hd-item-title">My Orders</div>
							</a> <a class="hd-item-link" href=""> <i
								class="far fa-user-circle"></i>
								<div class="hd-item-title">My Account</div>
							</a> <a class="hd-item-link" href="../auth/logout"> <i
								class="fas fa-fw fa-sign-out-alt"></i>
								<div class="hd-item-title">Logout</div>
							</a>
						</div>
					</c:if>
					<c:if test="${ empty userLogin}">
						<a class="dn" href="../auth/login"> <i
							class="fas fa-fw fa-sign-in-alt"></i> <span>Login</span>
						</a>
						<span>|</span>
						<a class="dn" href="Login/Signup"> <i
							class="fas fa-fw fa-user-plus"></i> <span>Register</span>
						</a>
					</c:if>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-sm  navbar-dark hd-tab-container"
			id="headercolor">
			<div class="collapse navbar-collapse hd-nav-wrapper" id="collapsible">
				<ul class="navbar-nav " id="menu">
					<c:forEach items="${tabs }" var="tab">
						<li class="nav-item hd-tab-item" role="presentation"><c:url
								var="tabUrl" value="../../category/${tab.name}">
								<c:param name="id" value="${tab.id}" />
							</c:url> <a class="m" href="${tabUrl }"> <img title="facebook"
								alt="facebook" src="${tab.iconImage.imageUrl }"> <span>${tab.name }</span>
						</a></li>
					</c:forEach>
				</ul>
			</div>
	</div>
	</nav>
	</div>

	<script type="text/javascript"
		src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>