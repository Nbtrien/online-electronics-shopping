<%@page import="com.shopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div id="home" class="container-content">
		<div class="row bg scrollbar" id="style-1">
			<c:forEach items="${model}" var="category">
				<div class="col-md-2 col-sm-3 col-3 dm">
					<a href="">
						<div class="bound">
							<div class="bor">
								<div class="im">
									<img src="${category.image.imageUrl }">
								</div>
							</div>
							<div class="cap">${category.name }</div>
						</div>
					</a>
				</div>
			</c:forEach>

		</div>

		<c:forEach items="${categories}" var="category">
			<div class="bg1">
				<h3 class="f-cat">${category.name }bestseller</h3>
				<div class="row">
					<c:forEach items="${category.products}" var="product">
						<div class="col-md-6 col-sm-6 col-xl-3 col-lg-4 col-6 coll">
							<c:set var="productName"
								value="${fn:replace(product.name,' ','-')}" />
							<c:url var="productURL" value="../product/${productName}">
								<c:param name="id" value="${product.id}" />
							</c:url>
							<a href="${productURL }">
								<div class="bound1">
									<div class="bor1">
										<img class="imsp" src="${product.image.imageUrl }">
										<div class="cap1">
											<div class="apd-name-wrapper">
												<div class="ten">${product.displayName }</div>
											</div>
											<div class="gia">
												<fmt:formatNumber value="${product.price}"
													minFractionDigits="0" maxFractionDigits="0" />
												VND
											</div>
										</div>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>