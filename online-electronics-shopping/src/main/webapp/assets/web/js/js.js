
$(document).ready(function() {
	// Chọn số lượng sản phẩm
	$("#sl").change(function() {
		var test = document.getElementById("sl").value;
		$.post("./Ajax/SetLimit", { sl: test }, function(result) {
			location.reload();
		});
	});

	// Kiểm tra form đăng ký
	$("#regisusername").keyup(function() {
		var un = document.getElementById("regisusername").value;
		$.post("./Ajax/CheckUsername", { uname: un }, function(result) {
			if (result == true) {
				$("#regisnameErr").html("*Tên này đã tồn tại");
				document.getElementById("regissubmit").disabled = true;
			}
			else {
				$("#regisnameErr").html("Tên gồm chữ cái và số");
				document.getElementById("regissubmit").disabled = false;
			}
		})
	});

	// Thêm vào giỏ hàng
	$("#bt_addcart").click(function() {
		var id_pro = $("#id_pro").val();
		var url = $("#inp_geturl").val();
		$.post("./Ajax/AddCart", { idpr: id_pro }, function(result) {
			if (result == true) {
				alert("Đã thêm vào giỏ hàng");
			}
			else {
				url = "Login/Signin&return=" + url;
				window.location = url;
			}
		});
	});

	// Mua ngay
	$("#bt_buynow").click(function() {
		var id_pro = $("#id_pro").val();
		var url = $("#inp_geturl").val();
		$.post("./Ajax/AddCart", { idpr: id_pro }, function(result) {
			var id_pro = $("#id_pro").val();
			if (result == true) {
				window.location = "Cart/ShowCart";
			}
			else {
				url = "Login/Signin&return=" + url;
				window.location = url;
			}
		});
	});

	// Xóa sản phẩm trong giỏ hàng
	$("button[id='task\\[\\]']").click(function() {
		var id_pro = $(this).val();
		$.post("./Ajax/DeleteProCart", { idpr: id_pro }, function(result) {
			location.reload();
		});
	});

	// Xóa giỏ hàng
	$("#bt_deletecart").click(function() {
		$.post("./Ajax/DeleteCart", {}, function(result) {
			location.reload();
		});
	});

	// Xử lý bình luận
	$("#gui_bl").click(function() {

		var id_pro = $("#id_pro").val();

		var id_user = $("#id_user").val();
		var username = $("#user").val();
		if (id_user != 0) {
			var fname = username.substr(0, 1);
			var avar = "";
		}
		else {
			var avar = "avar";
			fname = "<img src='public/images/avatar.png'>";
		}

		var txt = $("#nd_bl").val();

		if (txt == "") { alert("Hãy nhập bình luận") }
		else
			$.post("./Ajax/AddComment", { comment: txt, idpr: id_pro, idus: id_user }, function(result) {
				$("#newbl").prepend("<div class='pr_bluan'><div><div class='rounded-corners " + avar + "'>" + fname + "</div></div><div><div style='display: flex; margin-bottom: 10px;''><div class='username'>" + username + "</div><div class='t_gian'>Bây giờ</div></div><div class='nd_binhluan'>" + txt + "</div><div><span><a class='ic' href='javascript:void(0)'><i class='fas fa-thumbs-up'></i>0</a></span><span><a class='ic' href='javascript:void(0)'><i class='fas fa-thumbs-down'></i>0</a></span><span><a class='ic' href='javascript:void(0)'><i class='material-icons'>comment</i>0</a></span></div></div></div>");
				$("#nd_bl").val("");
			});
	});

	// Tìm kiếm
	$("#bt_search").click(function() {
		var key = $("#key_word").val();
		key = key.trim()
		// alert(key.replace(/\s/g,"") == "");
		if (key.replace(/\s/g, "") == "") {
			alert(key);
		}
		else {
			var url = "Search/" + key;
			window.location = url;
		}
	});

	// Tìm kiếm theo giá
	$("#bt_price").click(function() {
		var min = Number($("#min_val").val());
		var max = Number($("#max_val").val());
		$("#price_Err").html("");
		var result = true;

		if ((min == 0) & (max == 0)) {
			$("#price_Err").html("* Hãy nhập khoảng giá phù hợp");
			result = false;
		}
		else {
			if ((min != 0) & (max != 0)) {
				if (min > max) {
					$("#price_Err").html("* Hãy nhập khoảng giá phù hợp");
					result = false;
				}

			}
		}

		if (result == true) {
			var url = $("#get_url").val();
			if (min != "") {
				url = url + "&min=" + min;
			}
			if (max != "") {
				url = url + "&max=" + max;
			}

			window.location = url;
			// alert(url);
		}
	});


	$("button[id='btn-submit-comment']").click(function() {

		var content = $("#txt-comment").val();
		var rate = $('input[name=rate]:checked').val();

		if (rate == undefined || content == "") {
			alert("PLEASE VOTING");
		} else {
			var proId = $('input[id=pd-input-id]').val();
			var userId = $('input[id=us-input-id]').val();
			$.ajax({
				type: "POST",
				url: "../product-reviews",
				data: { rating: rate, content: content, userId: userId, productId: proId },
				success: function(response) {
					window.location.reload();
				}

			});
		}
	});

	$("button[id='btn-add-cart']").click(function() {
		var proId = $('input[id=pd-input-id]').val();
		var userId = $('input[id=us-input-id]').val();
		var price = $('input[id=pd-price-input-id]').val();
		var qtySelect = document.getElementById("pd-qty-sl-input");
		var qTy = qtySelect.value;

		if (userId !== "") {
			$.ajax({
				type: "POST",
				url: "../cart-items/create",
				data: { productId: proId, userId: userId, price: price, quantity: qTy },
				success: function(response) {
					alert(response);
					/*window.location.reload();*/
				}

			});
		} else {
			window.location = "../auth/login";
		}
	});

	function validatepaymentform() {
		e.preventdefault();
	};
	$("button[id='btn-order']").click(function() {

		var userId = $('input[id=us-input-id]').val();
		var totalPrice = $('input[id=ip-total-price]').val();
		var productIds = $("input[id='ip-products-id[]']")
			.map(function() { return $(this).val(); }).get();
		var productPrices = $("input[id='ip-products-price[]']")
			.map(function() { return $(this).val(); }).get();
		var productQuantities = $("input[id='ip-products-quantity[]']")
			.map(function() { return $(this).val(); }).get();

		var name = $('input[id=ip-order-name]').val();
		var mobile = $('input[id=ip-order-mobile]').val();
		var email = $('input[id=ip-order-email]').val();
		var address = $('input[id=ip-order-address]').val();

		if (name !== "" & mobile !== "" & address !== "") {
			$.ajax({
				type: "POST",
				url: "../orders/create",
				data: { fullName: name, mobile: mobile, email: email, address: address, subTotal: totalPrice, userId: userId, productIds: productIds, productPrices: productPrices, productQuantities: productQuantities },
				success: function(response) {
					alert(response);
					/*window.location.reload();*/
				},
				fail: function(xhr, textStatus, errorThrown) {
					alert('request failed');
				}
			});
		} else {
			alert("PLEASE ENTER YOUR INFORMATION!")
		}

	});



});
