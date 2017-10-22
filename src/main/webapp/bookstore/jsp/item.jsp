<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="icon.jsp"%>
<%
	String path = request.getContextPath();
%>
<%
	Book book = new Book();
	String cover = "";
	if (request.getAttribute("book") != null) {
		book = (Book) request.getAttribute("book");
	}
	if (request.getAttribute("cover") != null) {
		cover = (String) request.getAttribute("cover");
	}
	int bookId = book.getId();
	String bookTitle = book.getTitle();
	String bookAuthor = book.getAuthor();
	String bookPublisher = book.getPublisher();
%>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/item.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/bookstore/css/Sbook.css" rel="stylesheet"
	type="text/css">
<title><%=bookTitle%> <%=bookAuthor%> 著</title>
</head>
<body>
	<div class="container-fluid">
		<%@include file="nav.jsp"%>
		<div class="row">
			<div class="col-md-3">
				<%=cover%>
			</div>
			<div class="col-md-3 item">
				<p><%=bookTitle%></p>
				<p><%=bookAuthor%></p>
				<p><%=bookPublisher%></p>
				<p><%=book.getDate()%></p>



				<div class="input-group spinner">
					<input type="text" class="form-control" value="1" id="booknumber">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<button type="button" class="btn btn-default" id="addtocart"
					data-id="<%=bookId%>">Add to cart</button>
				<button type="button" class="btn btn-primary" id="buynow">Buy
					Now</button>
			</div>
		</div>
		<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
		<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
		<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
		<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
		<script src="<%=path%>/bookstore/js/bookstore.js"></script>
		<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>
		<script src="<%=path%>/bookstore/js/item.js"></script>
</body>
</html>