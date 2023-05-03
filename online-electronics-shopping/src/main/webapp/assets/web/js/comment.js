$(document).ready(function() {
	$("a[id='showrepcomm\\[\\]']").live('click', function() {
		var id = $(this).attr('at');
		$("div[id='addrepcomm[" + id + "]']").show();
	});
	$("button[id='submit_repcomm\\[\\]']").click(function() {
		var id1 = $(this).val();
		var id_user = $("input[id='id_user[" + id1 + "]']").val();
		var nd = $("textarea[id='nd_repcomm[" + id1 + "]']").val();
		var idrepcomm = id1;
		var rn = $("input[id='repname[" + id1 + "]']").val();
		var fn = rn.substr(0, 1);
		$.post("./Ajax/AddRepComment", { idcomm: idrepcomm, comment: nd, idus: id_user }, function(result) {
			$("div[id='new_repcomm[" + id1 + "]']").prepend("<div class='pr_bluan'><div><div class='rounded-corners'>" + fn + "</div></div><div><div style='display: flex; margin-bottom: 10px;''><div class='username'>" + rn + "</div><div class='t_gian'>Bây giờ</div></div><div class='nd_binhluan'>" + nd + "</div><div><span><a class='ic' href='javascript:void(0)'><i class='fas fa-thumbs-up'></i>0</a></span><span><a class='ic' href='javascript:void(0)'><i class='fas fa-thumbs-down'></i>0</a></span><span><a class='ic' href='javascript:void(0)'><i class='material-icons'>comment</i>0</a></span></div></div></div>");
			$("textarea[id='nd_repcomm[" + id1 + "]']").val("");
		});
	});
});