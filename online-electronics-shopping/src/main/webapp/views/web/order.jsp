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
				<div class="order-head-wrapper">
					<div>
						<div>Order (${orderItems.size() } products)</div>
					</div>
					<div></div>
				</div>
				<div class="order-top-wrapper">
					<div>
						Total:
						<fmt:formatNumber value="${total}" minFractionDigits="0"
							maxFractionDigits="0" />
						VND
					</div>
					<div class="cart-top-price-wr">Price</div>
				</div>
				<hr>
			</div>

			<c:set var="total" value="${0}" />
			<div class="fom">

				<c:forEach items="${orderItems }" var="orderItem">
					<div class="pro">
						<div class="row">
							<div class="col-xl-3">
								<img src="${orderItem.product.image.imageUrl }">
							</div>
							<div class="col-xl-7 ">
								<div class="tenhag">

									<div>${orderItem.product.displayName}</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub">Gift options not
											available.Gift options not available. <a href="">Learn
												more</a>
										</span>
									</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub a-txt-bold">Quantity: </span> <span
											class="cart-pd-sub">${ orderItem.quantity} </span>
									</div>
									<div class="cart-pd-sub-wrapper">
										<span class="cart-pd-sub a-txt-bold">Order placed: </span> <span
											class="cart-pd-sub"><fmt:formatDate
												value="${ orderItem.createdAt}" pattern="dd/MM/yyyy" /> </span>
									</div>
									<div class="cart-pd-sub-wrapper">
										<a href="" class="cart-pd-sub">Buy again</a> <i
											class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Save
											for later</a> <i
											class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Compare
											with similar items</a> <i
											class="a-icon a-icon-text-separator sc-action-separator"
											role="img" aria-label="|"></i> <a href="" class="cart-pd-sub">Delete</a>
									</div>
								</div>
							</div>
							<div class="col-xl-2">
								<div class="cart-pd-price">
									<fmt:formatNumber value="${orderItem.price}"
										minFractionDigits="0" maxFractionDigits="0" />
									VND
								</div>
							</div>
						</div>
					</div>
					<c:set var="total"
						value="${total + orderItem.price*orderItem.quantity}" />
				</c:forEach>
			</div>
		</div>
	</div>


</body>
</html>