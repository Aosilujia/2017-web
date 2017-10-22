<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Bookstock"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>BookStore</title>
<%@ include file="logincheck.jsp"%>
<%@include file="icon.jsp"%>
<%@ include file="logincheckadmin.jsp"%>
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
	<%
		ArrayList<Bookstock> bookstockList = new ArrayList<Bookstock>();
		if (request.getAttribute("bookstocks") != null) {
			bookstockList = (ArrayList<Bookstock>) request.getAttribute("bookstocks");
		}
		ArrayList<Book> bookList = new ArrayList<Book>();
		if (request.getAttribute("books") != null) {
			bookList = (ArrayList<Book>) request.getAttribute("books");
		}
	%>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">BookStore</a>
		</div>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="allUsersPro"><i class="fa fa-user fa-fw"></i>
							Users</a></li>
					<li><a href="allBooksPro" ><i
							class="fa fa-book fa-fw"></i> Books</a></li>
					<li><a href="allOrdersPro"><i class="fa fa-reorder fa-fw"></i>
							Orders</a></li>
					<li><a href="allOrderitemsPro"><i
							class="fa fa-table fa-fw"></i> Orderitems</a></li>
					<li><a href="allBookstockPro" class="active"><i
							class="fa fa-table fa-fw"></i> Bookstock</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Book stock</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							add book stock
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
											<th>Stock</th>
											<th>Price</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < bookstockList.size(); i++) {
												Bookstock bookstock = bookstockList.get(i);
										%>
										<tr>
											<td><%=bookstock.getId()%></td>
											<td><%=bookstock.getStock()%></td>
											<td><%=bookstock.getPrice()%></td>
											<td>
												<button class="btn btn-default delete" type="button"
													data-id="<%=bookstock.getId()%>">
													<i class="fa fa-trash"></i>
												</button>
												<button class="btn btn-default edit" type="button"
													data-id="<%=bookstock.getId()%>"
													data-stock="<%=bookstock.getStock()%>"
													data-price="<%=bookstock.getPrice()%>">
													<i class="fa fa-edit"></i>
												</button>
											</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
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
									<label>Stock</label> <input class="form-control" type="number"
										name="stock">
								</div>
								<div class="form-group">
									<label>Price</label> <input class="form-control" type="number"
										step="0.01" name="price">
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

	<script src="<%=path%>/bookstore/js/bookstock.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>

