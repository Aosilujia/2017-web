<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="icon.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新用户注册</title>
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="divFrame">
					<div class="divTitle">用户注册</div>
					<div class="divContent">
						<div id="box">
							<form id="myForm">
								<div class="form-group">
									<label>用户名</label> <input class="form-control" name="username"
										id="username">
								</div>
								<div id="divTip" style="color:#F00"></div>
								<div class="form-group">
									<label>密码</label> <input type="password" class="form-control"
										name="password" id="password">
								</div>
							</form>
							<button id="regisconfirm" type="button" class="btn btn-primary">注册</button>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/login.js"></script>

</body>
</html>