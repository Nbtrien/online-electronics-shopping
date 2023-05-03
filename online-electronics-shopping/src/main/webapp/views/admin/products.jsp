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
	<div id="product-mana">
		<h1>Products Management</h1>
		<div class="bg">
			<div class="head">
				<h3>
					<span class="ds">Products List</span> <span class="tp"><a
						href="../admin/products/create"><i
							class="fas fa-fw fa-plus-circle"></i> Add Product</a></span>
					<div style="clear: right;"></div>
				</h3>

			</div>
			<div class="cont">
				<table id="myTable" class="table table-striped">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
							<th>Image</th>
							<th>Categories</th>
							<th>Price (VND)</th>
							<th>Quantity</th>
							<th>Total sold</th>
							<th>Active</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${model}" var="product">
							<tr id="">
								<td>${product.id}</td>
								<td>${product.name}</td>
								<td><img src=" <c:url value="${product.image.imageUrl}"/>">
								</td>
								<td>${product.category.id}</td>
								<td><fmt:formatNumber value="${product.price}"
										minFractionDigits="0" maxFractionDigits="0" /></td>
								<td>${product.quantity}</td>
								<td>${product.quantity}</td>
								<td><c:url var="productURL"
										value="../admin/products/meta/create?name=${product.name }">
										<c:param name="id" value="${product.id}" />
									</c:url> <a href="${ productURL}"><i class="fas fa-cog"></i>Update
								</a> <br>
									<button class="bt_del" id="bt_delete[]" value="">
										<i class="fas fa-trash-alt"></i>Delete
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>