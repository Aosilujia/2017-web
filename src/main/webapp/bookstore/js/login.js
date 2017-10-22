$(function() {
	$("#regisbutton").click(function(){
		top.location.href = "register";
	}
	);
	
	$("#loginbutton").click(function() {
		var name = $("input[name='username']").val();
		var pass = $("input[name='password']").val();
		$.ajax({
			url : 'loginUser',
			dataType : "html",
			data : {
				username : name,
				password : pass,
			},
			success : function(strvalue) 
				{
				if(strvalue=="true"){
					$("#divTip").html("successful");
					var prevLink=document.referrer;
					if($.trim(prevLink)==''){
					    window.location.href = 'Home';  
						}
					else{
					    window.location.href = prevLink;  
						}  
					}
				else{
					var info="incorrect username or password";
					$("#divTip").html(info);
					}
				}
			});
	});
	
	$('#regisconfirm').click(function(){
		var name = $("input[name='username']").val();
		var pass = $("input[name='password']").val();
		$.ajax({
			url : 'registeruser',
			dataType : "html",
			data : {
				username : name,
				password : pass,
			},
			success:function(data){
				console.log(data);
				if (data=="success"){
					bootbox.alert({
						message : 'Register Successfully! ',
						callback : function() {
							window.location.href = 'login'; 
						}
					});
				}
				else{
					$("#divTip").html("duplicate username");
				}
				
			}
			
		}
		);
		
	});
	
	
});



