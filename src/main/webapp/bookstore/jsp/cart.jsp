<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page import="model.Order"%>
<%@ page import="model.Orderitem"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>My Cart</title>
<%@include file="icon.jsp"%>

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
		ArrayList<Orderitem> orderitemList = new ArrayList<Orderitem>();
		if (session.getAttribute("carts") != null) {
			orderitemList = (ArrayList<Orderitem>) session.getAttribute("carts");
		}
		ArrayList<Order> orderList = new ArrayList<Order>();
		if (request.getAttribute("orders") != null) {
			orderList = (ArrayList<Order>) request.getAttribute("orders");
		}
		ArrayList<Book> bookList = new ArrayList<Book>();
		if (session.getAttribute("cartbooks") != null) {
			bookList = (ArrayList<Book>) session.getAttribute("cartbooks");
		}
	%>

	<div id="container-fluid">
			<%@include file="nav.jsp"%>
		<div class="row">
			<div class="col-lg-12 item">
				<p style="font-size: 32px;">Carts</p>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						确认下单
						<button class="btn btn-default" type="button" id="order">
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
										<th>Title</th>
										<th>Amount</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < orderitemList.size(); i++) {
											Orderitem orderitem = orderitemList.get(i);
											Book book = bookList.get(i);
									%>
									<tr>
										<td><%=book.getTitle()%></td>
										<td><%=orderitem.getAmount()%></td>
										<td>
											<button class="btn btn-default delete" type="button"
												data-id="<%=i%>">
												<i class="fa fa-trash"></i>
											</button>
											<button class="btn btn-default edit" type="button"
												data-id="<%=orderitem.getId()%>"
												data-bookid="<%=orderitem.getBookid()%>"
												data-amount="<%=orderitem.getAmount()%>">
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
									<label>Book</label> <select class="form-control" id="bookid">
										<%
											for (int i = 0; i < bookList.size(); i++) {
												Book book = bookList.get(i);
										%>
										<option value="<%=book.getId()%>"><%=book.getTitle()%></option>
										<%
											}
										%>

									</select>
								</div>
								<div class="form-group">
									<label>Amount</label> <input class="form-control" type="number"
										name="amount">
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

	<script src="<%=path%>/bookstore/js/cart.js"></script>

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

