(function ($) {  
  $('.spinner .btn:first-of-type').on('click', function() {  
    $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);  
  });  
  $('.spinner .btn:last-of-type').on('click', function() {  
    $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);  
  });  
})(jQuery); 

$(function(){
	$("#view").click(function(e){
		var dataset = e.currentTarget.dataset;
		var bookid=dataset.id;
		var url='Bookitem?id='+bookid;
		console.log(url);
		window.location.href=url;
	})
	
	
	
	$("#addtocart").click(function(e){
		var dataset = e.currentTarget.dataset;
		var bookid = dataset.id;
		var amount=document.getElementById("booknumber").value;
		jQuery.ajax({
			url : 'addtoCart',
			processData : true,
			dataType : "text",
			data : {
				bookid : bookid,
				amount : amount
			},
			success : function(data) {
				console.log(bookid);
				bootbox.alert({
					message : 'bookid='+bookid
						+ 'amount='+amount,
					callback : function() {
						location.reload();
					}
				});
			}
		})
	})
	
	$("#buynow").click(function(e){
		
		
	})
})