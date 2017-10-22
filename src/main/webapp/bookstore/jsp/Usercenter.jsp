<%@ page import="java.util.ArrayList"%>
<%@ page import="model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>BookStore</title>
<%@include file="icon.jsp"%>
<%@include file="logincheck.jsp"%>
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
	<%
		UserInfo userinfo = new UserInfo();
		if (session.getAttribute("info") != null) {
			userinfo = (UserInfo) session.getAttribute("info");
		}
	%>
	<div id="containter-fluid">
		<%@include file="nav.jsp"%>

		<div class="row">
			<div class="col-lg-12 item">
				<p style="font-size: 32px;">UserInfo</p>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						add user
						<button class="btn btn-default" type="button" id="add">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables">
								<thead>
									<tr>
										<th>ID</th>
										<th>Nickname</th>
										<th>Email</th>
										<th>Sex</th>
										<th>Area</th>
										<th>birthday</th>
									</tr>
								</thead>
								<tbody>
									<%
										
									%>
									<tr>
										<td><%=userinfo.getId()%></td>
										<td><%=userinfo.getNickname()%>
										<td><%=userinfo.getEmail()%></td>
										<td><%=userinfo.getSex()%></td>
										<td><%=userinfo.getArea()%></td>
										<td><%=userinfo.getBirthday()%>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
				<button type="button" class="btn btn-default" id="edit"
					data-id="<%=userinfo.getId()%>"
					data-nickname="<%=userinfo.getNickname()%>"
					data-email="<%=userinfo.getEmail()%>"
					data-sex="<%=userinfo.getSex()%>"
					data-area="<%=userinfo.getArea()%>"
					data-birthday="<%=userinfo.getBirthday()%>">Edit</button>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="modalTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<label>Username</label> <input class="form-control"
										name="username">
								</div>
								<div class="form-group">
									<label>Password</label> <input class="form-control"
										name="password">
								</div>
								<div class="form-group">
									<label>Role</label> <input class="form-control" name="role">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
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

	<script src="<%=path%>/bookstore/js/usercenter.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		var div = document.getElementById('userli');
		div.setAttribute("class", "active");
	</script>
</body>

</html>

