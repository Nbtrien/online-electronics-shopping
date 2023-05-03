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
	<div id="Categories-mana">
		<h1>Categories Management</h1>
		<div class="bg">
			<div class="head">
				<h3>Categories</h3>
			</div>
			<div class="fom">
				<div class="row">
					<c:forEach items="${model}" var="category">
						<div class="col-xl-2 col-md-3 col-sm-4 mb-2 coll" id="">
							<button class="close" id="deletecat[]" aria-label="Close"
								value="">
								<span aria-hidden="true" style="color: #7CFC00">&times;</span>
							</button>
							<a href="javascript:void(0)" at="" class="dm" id="xxx[]"
								onmousedown="WhichButton(event)">
								<div class="card-dm">
									<div class="div-dm">
										<span class="text-dm"> ${category.name} </span> <input
											type="hidden" id="" value="ten"> <input type="hidden"
											id="" value=""> <span class="sp-dm" id="">
											<button class="but-dm" id="editcat[]" value="">Edit</button>
										</span>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
				<br>
				<button class="addcat" id="addcat">
					<i class="fas fa-fw fa-plus-circle"></i> Add New Category
				</button>
			</div>

			<div class="fom">
				<span id="add">
					<h3>Add New Category</h3>
					<form name="addcatform" method="post" action="../admin/categories"
						enctype="multipart/form-data">
						<label>Name: </label> <input type="text" name="name"
							placeholder="Name"> <br> <span class="Error"
							id="nameErr"></span> <br> <label>Add Image: </label> <input
							type="hidden" name="size" value="1000000"> <input
							type="file" name="image"> <span class="Error"
							id="imageErr"></span> <br>
						<button class="sub" type="submit" name="bt_addcat">Add</button>
						<button class="sub" id="bt_cancel" type="reset"
							style="margin-left: 10px;">Cancel</button>
						
					</form>
					<br>
				</span>
			</div>
		</div>
		
				<div class="bg">
			<div class="head">
				<h3>Brands</h3>
			</div>
			<div class="fom">
				<div class="row">
					<c:forEach items="${brands}" var="brand">
						<div class="col-xl-2 col-md-3 col-sm-4 mb-2 coll" id="">
							<button class="close" id="deletecat[]" aria-label="Close"
								value="">
								<span aria-hidden="true" style="color: #7CFC00">&times;</span>
							</button>
							<a href="javascript:void(0)" at="" class="dm" id="xxx[]"
								onmousedown="WhichButton(event)">
								<div class="card-dm">
									<div class="div-dm">
										<span class="text-dm"> ${brand.name} </span> <input
											type="hidden" id="" value="ten"> <input type="hidden"
											id="" value=""> <span class="sp-dm" id="">
											<button class="but-dm" id="editcat[]" value="">Edit</button>
										</span>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
				<br>
				<button class="addcat" id="addbrand">
					<i class="fas fa-fw fa-plus-circle"></i> Add New Brand
				</button>
			</div>

			<div class="fom">
				<span id="add-brand">
					<h3>Add New Category</h3>
					<form name="addbrandform" method="post" action="../admin/brands"
						enctype="multipart/form-data">
						<label>Name: </label> <input type="text" name="name"
							placeholder="Name"> <br> <span class="Error"
							id="nameErr"></span> <br> <label>Add Image: </label> <input
							type="hidden" name="size" value="1000000"> <input
							type="file" name="image"> <span class="Error"
							id="imageErr"></span> <br>
						<button class="sub" type="submit" name="bt_addcat">Add</button>
						<button class="sub" id="bt-cancel-brand" type="reset"
							style="margin-left: 10px;">Cancel</button>
					</form>
					<br>
				</span>
			</div>
		</div>
	</div>
</body>
</html>