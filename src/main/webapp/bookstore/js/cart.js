$(function() {

	$("#order").click(function(e){
		jQuery.ajax({
			url:'placeOrder',
		})
		location.reload();
	})
	
	
	
	$("#save").click(function(e) {
		var arrayid = $("#orderid").val();
		var bookid = $("#bookid").val();
		var amount = $("input[name='amount']").val();
		console.log(arrayid, bookid, amount);

		var dataset = e.currentTarget.dataset;
		var id = dataset.id;

		if (id != "") { // Edit
			jQuery.ajax({
				url : 'updateCart',
				processData : true,
				dataType : "text",
				data : {
					arrayid : arrayid,
					bookid : bookid,
					amount : amount
				},
				success : function(data) {
					console.log(id);
					bootbox.alert({
						message : 'Modify Successfully! '
							+ 'PS: No change if foreign key does not exist!',
					    callback : function() {
					       location.reload();
					    }
					});
				}
			});
		} else { // Add
			jQuery.ajax({
				url : 'addOrderitemPro',
				processData : true,
				dataType : "text",
				data : {
					orderid : orderid,
					bookid : bookid,
					amount : amount
				},
				success : function(data) {
					bootbox.alert({
						message : 'Add Successfully! '
							+ 'PS: No change if foreign key does not exist!',
						callback : function() {
							location.reload();
						}
					});
				}
			})
		}

		$('#modal').modal('hide');
	});

	$(".delete").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : 'Delete'
				},
				cancel : {
					label : 'Cancel'
				}
			},
			message : 'Sure to delete?',
			callback : function(result) {
				if (result) {

					var dataset = e.currentTarget.dataset;
					var arrayid = dataset.id;
					jQuery.ajax({
						url : 'deleteOrderitemPro',
						processData : true,
						dataType : "text",
						data : {
							arrayid : arrayid
						},
						success : function(data) {
							console.log(arrayid);
							bootbox.alert({
								message : 'Delete Successfully! '
									+ 'PS: No change if foreign key does not exist!',
							    callback : function() {
									location.reload();
								}
							});
						}
					});

				}
			}
		});
	});

	$("#add").click(function(e) {
		$('#modalTitle').html("Add");

		$("#orderid").val("");
		$("#bookid").val("");
		$("input[name='amount']").val("");

		$("#save").attr("data-id", "");
		$('#modal').modal('show');
	});

	$(".edit").click(function(e) {
		$('#modalTitle').html("Edit");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		console.log(id);

		$("#bookid").val(dataset.bookid);
		$("input[name='amount']").val(dataset.amount);

		$("#save").attr("data-id", dataset.id);
		$('#modal').modal('show');
	});

});
