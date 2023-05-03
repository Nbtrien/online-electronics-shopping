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

	<div id="add-product">
		<h1>Products Management</h1>

		<div class="bg">
			<div class="head">
				<h4>Add Product</h4>
			</div>
			<div class="fom">
				<form name="addproductform" method="post"
					action="<c:url value='/admin/products/create'/>"
					enctype="multipart/form-data">
					<div>
						<p>
							<label>Name: </label> <input type="text" name="name"><span
								class="err" id="nameErr"></span>
						</p>
						<p>
							<label>Display Name: </label> <input type="text" name="displayName"><span
								class="err" id="nameErr"></span>
						</p>
						<p>
							<label>Quantity: </label> <input type="number" name="quantity"
								min="1">
						</p>
						<p>
							<label>Price: </label> <input type="number" name="price"
								min="1000">
						</p>
						<span class="err" id="priceErr"></span>
						<p>

							<label>Category: </label> <select class="select"
								name="category_id">
								<c:forEach items="${model}" var="category">
								${category.name}
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
							</select>
						</p>

						<p>
							<label>Brand: </label> <select class="select" name="brand_id">
								<c:forEach items="${brands}" var="brand">
								${brand.name}
									<option value="${brand.id}">${brand.name}</option>
								</c:forEach>
							</select>
						</p>
						<p>
							<label>Warranty: </label> <input type="date" name="warranty">
						</p>

						<p>
							<label><b>Image: </b></label> <input type="hidden" name="size"
								value="1000000"> <input type="file" name="image">
						</p>
						<p>
							<label>Description: </label>
						</p>
						<textarea class="ckeditor" name="description" cols="60" rows="10">
       					</textarea>
						<script>
							CKEDITOR.replace('editor1');
						</script>
						<br> <span class="err" id="imageErr"></span> <br> <br>
						<button class="sub" type="submit" name="bt_addpro">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>