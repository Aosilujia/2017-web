<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="icon.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>upload image</title>
<script language="javascript">
	function confirmclear() {
		if (confirm("确定要清除所有内容？\n注意！此操作不可撤销！")) {
			editor.txt.clear();
		}
	}
</script>
<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container">
		<button id="btn1">获取html</button>
		<button id="btn2">获取text</button>
		<br></br>

		<form name="planform">
			<div style="float: left;">编号：</div>
			<div>
				<p>
					<input name="number" id="number" type="number">&nbsp;（注意：最多20个字！）
				</p>
			</div>

			<div style="float: left;">路线类型：</div>
			<div>
				<p>
					<input type="radio" name="plantype" id="plantype"
						value="individual" />自助游&nbsp; <input type="radio"
						name="plantype" id="plantype" value="group" />跟团游&nbsp; <input
						type="radio" name="plantype" id="plantype" value="selfdrive" />自驾游
				</p>
			</div>

			<div id="toolbar_div" class="toolbar"></div>

			<div style="padding: 5px 0; color: #ccc">中间隔离带</div>

			<div id="text_div" class="text"></div>
			<br></br>
			<button style="float: left;" id="btnpub">发布路线</button>
		</form>
		&nbsp;
		<button onclick="confirmclear()">清空内容</button>
	</div>
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>/bookstore/js/wangEditor/wangEditor.min.js"></script>
	<script type="text/javascript">
		var E = window.wangEditor
		var editor = new E('#toolbar_div', '#text_div') // 或者 var editor = new E( document.getElementById('#editor') )
		editor.customConfig.uploadImgShowBase64 = true // 使用 base64 保存图片
		editor.create();

		document.getElementById('btn1').addEventListener('click', function() {
			// 读取 html
			alert(editor.txt.html())
		}, false)

		document.getElementById('btnpub').addEventListener('click', function() {
			// 读取 text
			var img = editor.txt.html();
			var number=document.getElementById("number").value;  
			jQuery.ajax({
				type : 'POST',
				url : 'saveImg',
				processData : true,
				dataType : "text",
				data : {
					img : img,
					number: number
				},
			})
			console.log(number);
			console.log(img);
			
		}, false)

		document.getElementById('btn2').addEventListener('click', function() {
			// 读取 text
			alert(editor.txt.text())
		}, false)
	</script>
</body>
</html>