<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="icon.jsp"%>
<title>Login Page</title>
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
					<div class="divTitle">用户登录</div>
					<div class="divContent">
						<div id="divTip"></div>
						<div id="box">
							<form id="myForm">
								<div class="form-group">
									<label>用户名</label> <input class="form-control" name="username"
										id="username">
								</div>
								<div class="form-group">
									<label>密码</label> <input type="password" class="form-control"
										name="password" id="password">
								</div>
							</form>
							<button id="loginbutton" type="button" class="btn btn-primary">登录</button>
							<button id="regisbutton" type="button" class="btn btn-warning">注册</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/login.js"></script>

</body>
</html>