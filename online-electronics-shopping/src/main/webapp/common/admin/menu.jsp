<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand">
					<div class="sname">
						<span>${userLogin.userName}</span>
						<hr>
					</div>

				</li>
				<li><a href="Admin/"><i class="fas fa-chart-bar"></i>Statics</a>
				</li>
				<li><a href="<c:url value='/admin/products'/>"><i
						class="fas fa-box-open"></i>Products Management</a></li>
				<li><a href="<c:url value='/admin/categories'/>"><i
						class="fas fa-list"></i>Categories Management</a></li>
				<li><a href="<c:url value='/admin/categories'/>"><i
						class="far fa-file-alt"></i>Orders Management</a></li>
				<li><a href="<c:url value='/admin/categories'/>"><i class="fas fa-user"></i>Users
						Management</a></li>
				<li><a href="<c:url value='/admin/categories'/>"><i
						class="material-icons">comment</i>Comments Management</a></li>
				<li><a href="http://localhost/MVC/Web_page/"><i
						class="fas fa-fw fa-sign-out-alt"></i>To Website</a></li>
			</ul>
		</nav>
		<button type="button" class="hamburger is-closed "
			data-toggle="offcanvas">
			<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
				class="hamb-bottom"></span>
		</button>
	</div>


</body>
</html>