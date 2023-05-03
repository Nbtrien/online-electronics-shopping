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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
</head>
<body>
	<c:out value="${productMetas }"></c:out>
	<div class="short-tab">
		<span><a href="">Home</a></span> / <span><a href="">${model.category.name}</a></span>
		/ <span><a href="">${model.brand.name}</a></span>
	</div>
	<div id="pro-detail" class="container-content">
		<div>
			<div class="dmuc">${model.displayName }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-7 col-sm-7 col-xl-7 col-lg-7">
				<div class="bor">
					<img src="${model.image.imageUrl }">
					<div class="l-pd-policy">
						<div class="l-pd-policy__item">
							<i class='fas fa-file-signature'></i> <span>Genuine
								product - Warranty 12 months</span>
						</div>
						<div class="l-pd-policy__item">
							<i class='fas fa-shipping-fast'></i> <span>Nationwide
								Delivery</span>
						</div>
					</div>
					<hr>
					<div class="ct">About this item</div>
					<div class="pd-desc-wrapper">
						<p>
							<c:out value="${model.description }" escapeXml="false" />
						</p>
					</div>

				</div>

			</div>
			<div class="col-md-5">
				<div class="bor">
					<div class="capt">
						<div>
							<div>${model.name }</div>
							<div>
								<fmt:parseNumber var="rating" type="number" parseLocale="number"
									value="${model.rating}" />
								<c:forEach var="i" begin="1" end="5">
									<fmt:parseNumber var="k" value="${i }" />
									<c:if test="${k <= rating}">
										<i class="fas fa-star" aria-hidden="true" style="color: gold;"></i>&nbsp;
								</c:if>
									<c:if test="${k > rating}">
										<c:choose>
											<c:when test="${k-1 < rating && rating < k}">
												<i class="fas fa-star-half-alt" aria-hidden="true"
													style="color: gold;"></i>&nbsp;
										</c:when>
											<c:otherwise>
												<i class="fas fa-star" aria-hidden="true"
													style="color: grey;"></i>&nbsp;
									</c:otherwise>
										</c:choose>
									</c:if>
								</c:forEach>
								<span class="pd-ratings-number">${model.reviews.size() }
									ratings and reviews</span>
							</div>
						</div>
						<hr>
						<div>
							<span class="sp-price"> <fmt:formatNumber
									value="${model.price}" minFractionDigits="0"
									maxFractionDigits="0" /> VND
							</span>
						</div>
						<div class="inf">
							<div class="row">
								<div class="col-md-4 sp-property">Category</div>
								<div class="col-md-6 sp-value">${model.category.name}</div>
							</div>
						</div>
						<div class="inf">
							<div class="row">
								<div class="col-md-4 sp-property">Quanity</div>
								<div class="col-md-6 sp-value">${model.quantity}</div>
							</div>
						</div>
						<div class="inf">
							<div class="row">
								<div class="col-md-4 sp-property">Brand</div>
								<div class="col-md-6 sp-value">${model.brand.name}</div>
							</div>
						</div>
						<div class="inf">
							<div class="row">
								<div class="col-md-4 sp-property">Warranty</div>
								<div class="col-md-6 sp-value">
									<fmt:formatDate value="${model.warranty}" pattern="dd/MM/yyyy" />
								</div>
							</div>
						</div>
						<hr>
						<c:if test="${model.quantity  > 0}">
							<div class="btgroup">
								<input type="hidden" id="inp_geturl" value="<?php echo $url ?>">
								<div>
									<label class="pd-sl-qty-label">Quantity: </label> <select
										class="pd-sl-qty-ip" name="quanitySelect" id="pd-qty-sl-input">
										<fmt:parseNumber var="quanity" value="${model.quantity }" />
										<c:forEach var="i" begin="1" end="${quanity }">
											<c:if test="${ i == 1 }">
												<c:set var="selected" value="selected"></c:set>
											</c:if>
											<c:if test="${ i != 1 }">
												<c:set var="selected" value=""></c:set>
											</c:if>
											<option value="${i}" ${selected }>${i}</option>
										</c:forEach>
									</select>
								</div>
								<div class="row">
									<div class="col-md-6">
										<button class="pd-btn gh" id="btn-add-cart">Add to
											Cart</button>
									</div>
									<div class="col-md-6">
										<button class="pd-btn mn" id="btn-buynow">Buy Now</button>
									</div>
								</div>


							</div>
						</c:if>
						<c:if test="${model.quantity  == 0}">
							<div class="oos">SOLD OUT</div>
						</c:if>
						<hr>
						<div class="pd-meta-wrapper">
							<div>Key Features</div>
							<div class="inf">
								<table class="table table-bordered pd-table">
									<tbody>
										<c:forEach items="${model.productMetas}" var="productMeta">

											<tr>
												<td>${productMeta.key}</td>
												<td>${productMeta.content}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
						<hr>
						<div>Products related to this item</div>
						<div class="pd-related-container">
							<c:forEach items="${relatedProducts}" var="relatedProduct">
								<div class="pd-rela-wrapper">
									<a href="">
										<div class="pd-rela-bound">
											<img class="pd-rela-item-img"
												src="${relatedProduct.image.imageUrl }">
											<div class="pd-rela-item-title">
												<div class="pd-item-name">${relatedProduct.displayName }</div>
												<div class="pd-item-price">
													<fmt:formatNumber value="${relatedProduct.price}"
														minFractionDigits="0" maxFractionDigits="0" />
													VND
												</div>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		</div>

		<br>
		<div class="pd-comment-wrapper">
			<div class="ct">Customer Review and Questions</div>

			<c:if test="${not empty userLogin}">
				<hr>
				<div class="ct">Your Review:</div>
				<div class="rate-container">
					<div class="rate">
						<input type="radio" id="star5" name="rate" value="5" /> <label
							for="star5" title="text">5 stars</label> <input type="radio"
							id="star4" name="rate" value="4" /> <label for="star4"
							title="text">4 stars</label> <input type="radio" id="star3"
							name="rate" value="3" /> <label for="star3" title="text">3
							stars</label> <input type="radio" id="star2" name="rate" value="2" /> <label
							for="star2" title="text">2 stars</label> <input type="radio"
							id="star1" name="rate" value="1" /> <label for="star1"
							title="text">1 star</label>
					</div>
				</div>

				<div class="add_comment">
					<div class="input_comment">
						<textarea id="txt-comment" rows="2"
							placeholder="Type your review ..."></textarea>
						<button class="pd-btn-sm" id="btn-submit-comment">Submit</button>
					</div>
				</div>
			</c:if>
			<c:if test="${ empty userLogin}">
				<div class="bt_sub">
					<a class="for_bl" href="../auth/login">
						Login To Send Your Review</a>
				</div>
			</c:if>
			<hr>
			<div class="post">
				<c:forEach items="${model.reviews }" var="review">
					<div class="pr_bluan">
						<div class="pd-cm-us-item">
							<i class="fa fa-user-circle"></i>
						</div>
						<div>
							<div style="display: flex; margin-bottom: 10px;">
								<div class="pd-comment-us-name">${review.user.userName }</div>
								<div class="pd-comment-time">
									<span> Reviewed on <fmt:formatDate
											value="${review.createdAt}" pattern="dd/MM/yyyy" />
									</span>

								</div>
							</div>
							<div>
								<fmt:parseNumber var="rating" value="${review.rating}" />
								<c:forEach var="i" begin="1" end="5">
									<fmt:parseNumber var="k" value="${i }" />
									<c:if test="${k <= rating}">
										<i class="fa fa-star" aria-hidden="true" style="color: gold;"></i>&nbsp;
									</c:if>
									<c:if test="${k > rating}">
										<i class="fa fa-star" aria-hidden="true" style="color: grey;"></i>&nbsp;
									</c:if>
								</c:forEach>
							</div>
							<div class="pd-comment-content ">${review.content }</div>
							<div></div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<input type="hidden" id="pd-input-id" value="${model.id }"> <input
			type="hidden" id="us-input-id" value="${userLogin.id }"> <input
			type="hidden" id="pd-price-input-id" value="${model.price }">

	</div>
</body>
</html>