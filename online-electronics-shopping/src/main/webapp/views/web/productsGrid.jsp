<%@page import="com.shopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
</head>
<body>
	<div id="allproduct" class="container-content">
		<center>
			<h2>${model.name}</h2>
			<span class='f-cat'> (${model.products.size()} products)</span>
		</center>
		<c:if test="${model.products.size() > 0}">
			<div class="row">
				<c:forEach items="${ model.products}" var="product">
					<div class="col-md-6 col-sm-6 col-xl-3 col-lg-4 col-6 coll">
						<c:set var="productName"
							value="${fn:replace(product.name,' ','-')}" />
						<c:url var="productURL" value="../product/${productName}">
							<c:param name="id" value="${product.id}" />
						</c:url>
						<a href="${productURL }">
							<div class="bound">
								<div class="bor">
									<img src="${product.image.imageUrl }">
									<div class="cap">
										<div class="apd-name-wrapper">
											<div class="ten">${product.displayName}</div>
										</div>

										<div class="gia">
											<fmt:formatNumber value="${product.price}"
												minFractionDigits="0" maxFractionDigits="0" />
											VND
										</div>
										<div style="clear: left"></div>
									</div>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>