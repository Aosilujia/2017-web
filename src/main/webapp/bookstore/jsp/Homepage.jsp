<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class=" responsive" lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="theme-color" content="#171a21">
<title>欢迎来到 Sbook</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
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
<link href="<%=path%>/bookstore/css/Sbook.css" rel="stylesheet"
	type="text/css">


</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<%@include file="nav.jsp"%>
				<div class="jumbotron">
					<img alt="Sbook" width="140" src="./bookstore/img/sbook.jpg" />
					<div class="col-md-9">
						<h1 style="text-align: center;">欢迎来到Sbook</h1>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 item">
					<img alt="" src="" />
					<h3></h3>
					<p></p>
				</div>
				<div class="col-md-4">
					<img alt="" src="" />
					<p></p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 item">
					<p style="font-size: 32px;" class="text-center">书是人类进步的阶梯</p>
					<p class="text-right">----高尔基</p>
				</div>
				<div class="col-md-4">
					<p>
						<a class="btn" href="Booklist" style="font-size: 32px;">See
							what we have »</a>
					</p>
				</div>
			</div>
		</div>
	</div>




	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>

	<script>
		var div = document.getElementById('homeli');
		div.setAttribute("class", "active");
	</script>
</body>
</html>