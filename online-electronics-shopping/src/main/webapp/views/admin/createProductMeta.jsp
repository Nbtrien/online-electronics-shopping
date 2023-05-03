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
			<div class="head add-pd-meta-head">
				<h4>Add Product Meta - ${product_name}</h4>
				<div class="add-pd-meta-number">
					<span>Add</span> <input id="meta-input-number"
						class="add-pd-meta-input" type="number" name="numberMeta" min="1"
						step="1"> <span>Meta(s)</span>
					<button id="meta-input-number-btn">Go</button>
				</div>
			</div>
			<div class="fom">
				<form name="addproductform" method="post"
					action="<c:url value='/admin/products/meta/create'/>"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-2 add-pd-meta-title">Key</div>
						<div class="col-md-10 add-pd-meta-title">Content</div>
					</div>
					<div id="add-pd-input-wrapper" class="add-pd-input-wrapper">
						<div class="row">
							<div class="col-md-2">
								<input type="text" name="keys" />
							</div>
							<div class="col-md-10">
								<input type="text" name="contents" />
							</div>
						</div>
					</div>
					<input type=hidden value="${product_id }" name="product_id"/>
					<button class="sub" type="submit" name="bt_addpro">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>