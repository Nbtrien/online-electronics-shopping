$(document).ready(function() {
	var trigger = $('.hamburger'),
		overlay = $('.overlay'),
		isClosed = false;

	trigger.click(function() {
		hamburger_cross();
	});

	function hamburger_cross() {

		if (isClosed == true) {
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
		} else {
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		}
	}

	$('[data-toggle="offcanvas"]').click(function() {
		$('#wrapper').toggleClass('toggled');
	});

	$("#add").hide();
	$("#edit").hide();
	$(".sp-dm").hide();

	$("#add-brand").hide();

	$("button[id='addcat']").click(function() {
		$("#edit").hide();
		$("#add").show();
	});

	$("button[id='addbrand']").click(function() {
		$("#add-brand").show();
	});

	$("button[id='bt-cancel-brand']").click(function() {
		$("#add-brand").hide();
	});

	$("a[id='xxx\\[\\]']").hover(function() {
		var id = $(this).attr('at');
		$("span[id='sp[" + id + "]']").show();
	},
		function() {
			$(".sp-dm").hide();
		});

	$("button[id='editcat\\[\\]']").click(function() {
		var id = $(this).val();
		var name = $("input[id='getcat[" + id + "]']").val();
		var idimage = $("input[id='getidimage[" + id + "]']").val();
		$("#add").hide();
		$("#edit").show();
		$("#editidcat").val(id);
		$("#editnamecat").val(name);
		$("#editidimage").val(idimage);
	});

	$("button[id='bt_cancel']").click(function() {
		$("#edit").hide();
		$("#add").hide();
	});

	$("#meta-input-number-btn").click(function() {
		var number = $("#meta-input-number").val();

		var divrow = document.createElement("div");
		divrow.classList.add('row');

		var divcol2 = document.createElement("div");
		divcol2.classList.add('col-md-2');
		var ipkey = document.createElement("input");
		ipkey.setAttribute("name", "keys");
		ipkey.setAttribute("type", "text");
		divcol2.appendChild(ipkey);

		var divcol10 = document.createElement("div");
		divcol10.classList.add('col-md-10');
		var ipcontent = document.createElement("input");
		ipcontent.setAttribute("name", "contents");
		ipcontent.setAttribute("type", "text");
		divcol10.appendChild(ipcontent);

		divrow.appendChild(divcol2);
		divrow.appendChild(divcol10);

		var parNode = document.getElementById("add-pd-input-wrapper");
		parNode.innerHTML = "";
		for (let i = 0; i < number; i++) {
			console.log(i);
			parNode.appendChild(divrow.cloneNode(true));
		}

	});
});