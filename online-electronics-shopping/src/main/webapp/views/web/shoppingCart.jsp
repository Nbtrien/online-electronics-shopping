<%@page import="com.shopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="cart" class="container-content">
		<div class="bg">
			<div class="head">
				<div>
					<span class="gh cart-tile-box">Shopping Cart </span>
				</div>
				<div class="cart-top-price-wr">Price</div>

				<hr>
			</div>

			<c:set var="total" value="${0}" />
			<div class="fom">

				<c:forEach items="${model.cartItems }" var="cartItem">


					<div class="pro">
						<div class="row">
							<div class="col-xl-3">
								<img src="${cartItem.product.image.imageUrl }">
							</div>
							<div class="col-xl-7 ">
								<div class="tenhag">

									<div>${cartItem.product.displayName}</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub">Gift options not
											available.Gift options not available. <a href="">Learn
												more</a>
										</span>
									</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub a-txt-bold">Category: </span> <span
											class="cart-pd-sub">${ cartItem.product.category.name}
										</span>
									</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub a-txt-bold">Brand: </span> <span
											class="cart-pd-sub">${ cartItem.product.brand.name} </span>
									</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub"> <label
											class="pd-sl-qty-label">Qty: </label> <select
											class="pd-sl-qty-ip" name="quanitySelect"
											id="pd-qty-sl-input">
												<fmt:parseNumber var="quanity"
													value="${cartItem.product.quantity }" />
												<fmt:parseNumber var="itemQty" value="${cartItem.quantity }" />

												<c:forEach var="i" begin="1" end="${quanity }">

													<c:if test="${itemQty == i }">
														<option value="${i}" selected>${i}</option>
													</c:if>
													<c:if test="${itemQty != i }">
														<option value="${i}">${i}</option>
													</c:if>
												</c:forEach>
										</select>
										</span> <i class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Delete</a>
										<i class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Save
											for later</a> <i
											class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Compare
											with similar items</a> <i
											class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Share</a>
									</div>
								</div>
							</div>
							<div class="col-xl-2">
								<div class="cart-pd-price">
									<fmt:formatNumber value="${cartItem.price}"
										minFractionDigits="0" maxFractionDigits="0" />
									VND
								</div>
							</div>
						</div>
					</div>

					<c:set var="total" value="${total + cartItem.price*cartItem.quantity }" />


					<input type="hidden" id="ip-products-id[]"
						value="${cartItem.product.id }">
					<input type="hidden" id="ip-products-price[]"
						value="${cartItem.price }">
					<input type="hidden" id="ip-products-quantity[]"
						value="${cartItem.quantity }">
				</c:forEach>
				<input type="hidden" id="ip-total-price" value="${total }">
				<input type="hidden" id="us-input-id" value="${userLogin.id }">
				<div class="cart-total-price-wr">
					Subtotal (${model.cartItems.size()} items): <span
						class="cart-pd-price"> <fmt:formatNumber value="${total}"
							minFractionDigits="0" maxFractionDigits="0" /> VND
					</span>
				</div>
				<div>
					<div style="clear: both;"></div>
					<div style="clear: both;"></div>
				</div>

				<br>
				<div class="cart-tile-box">Contact Information</div>
				<hr>
				<div>
					<div class="cart-box-input box-ip-flex">
						<input class="inf" type="text" id="ip-order-name" value=""
							placeholder="Type your name"> <input class="inf"
							type="text" id="ip-order-mobile" value=""
							placeholder="Type your phone number">

					</div>
					<div class="cart-box-input">
						<input class="inf" type="text" id="ip-order-email" value=""
							placeholder="Type your email">

					</div>
					<div class="cart-box-input">
						<input class="inf" type="text" id="ip-order-address" value=""
							placeholder="Type your address">

					</div>
					<input type="hidden" name="paymenttotal" value="">
					<div class="box-ip-flex">
						<button class="bt" id="btn-order">PLACE ORDER</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>