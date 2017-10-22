<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>BookStore</title>
<%@include file="icon.jsp"%>
<%
	String path = request.getContextPath();
%>
<%
	ArrayList<Book> bookList = new ArrayList<Book>();
	if (request.getAttribute("books") != null) {
		bookList = (ArrayList<Book>) request.getAttribute("books");
	}
	ArrayList<String> coverList = new ArrayList<String>();
	if (request.getAttribute("covers") != null) {
		coverList = (ArrayList<String>) request.getAttribute("covers");
	}
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
		<%@include file="nav.jsp"%>
		<%
			for (int i = 0; i < bookList.size(); i++) {
				Book book = bookList.get(i);
		%>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<%=coverList.get(i) %>
				</div>
				<div class="col-md-3 item">
					<p>
						作者:<%=book.getAuthor()%></p>
					<p>
						出版社:<%=book.getPublisher()%></p>
					<p>
						出版日期:<%=book.getDate()%></p>
				</div>
				<div class="col-md-3">
					<input type="button" class="btn btn-primary"
						onclick="window.location.href='Bookitem?id=<%=book.getId()%>'"
						value="查看具体信息"></input>
				</div>
				<ul class="nav nav-list">
					<li class="divider"></li>
				</ul>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/item.js"></script>
	<script>
		var div = document.getElementById('bookli');
		div.setAttribute("class", "active");
	</script>
</body>

</html>