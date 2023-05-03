<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet">
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet"
		href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
	
	<link href="<c:url value='/assets/admin/css/style.css' />"
		rel="stylesheet" type="text/css">
	<link href="<c:url value='/assets/admin/css/header.css' />"
		rel="stylesheet" type="text/css">
	<link href="<c:url value='/assets/admin/css/menu.css' />"
		rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/common/admin/header.jsp"%>
	<%@ include file="/common/admin/menu.jsp"%>

	<div id="page-content">
		<dec:body />
	</div>

	<%@ include file="/common/admin/footer.jsp"%>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="<c:url value='/assets/admin/js/admin.js' />"></script>
	<script src="<c:url value='/assets/admin/ckeditor/ckeditor.js' />"></script>
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</body>


</html>