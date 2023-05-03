<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web</title>
<link href="<c:url value='/assets/web/css/style5.css' />"
	rel="stylesheet" type="text/css">
<link href="<c:url value='/assets/web/css/style.css' />"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>

	<div>
		<dec:body />
	</div>

	<%@ include file="/common/web/footer.jsp"%>
	<script src="<c:url value='/assets/web/js/js.js' />"></script>
</body>
</html>