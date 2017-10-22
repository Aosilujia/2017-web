<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Static</title>
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
		int[] sales = new int[100];
		if (request.getAttribute("booksale") != null) {
			sales = (int[]) request.getAttribute("booksale");
		}
		ArrayList<Book> bookList = new ArrayList<Book>();
		if (request.getAttribute("books") != null) {
			bookList = (ArrayList<Book>) request.getAttribute("books");
		}
	%>


	<div class="container-fluid">
		<%@include file="nav.jsp"%>
		<div class="row">
			<canvas id="canvas1" width="450" height="450"> Your
			web-browser does not support the HTML 5 canvas element. </canvas>
		</div>
	</div>
	
	
		<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	
	<script type="application/javascript"
		src="<%=path%>/bookstore/js/awesomechart.js"></script>

	<script type="application/javascript">
		
		
		
      function drawMyChart(){
        if(!!document.createElement('canvas').getContext){ //check that the canvas
                                                           // element is supported
            var mychart = new AwesomeChart('canvas1');
        	var amounts=[];
        	var books=[];
        	
	<%for (int i = 0; i < bookList.size(); i++) {
				Book book = bookList.get(i);
				int bid = book.getId();%>
		
        	amounts.push(
	<%=sales[bid]%>
		);
        	books.push("<%=book.getTitle()%>");
        	
	<%}%>
		
            mychart.title = "Book Sales - Total";
            mychart.data =amounts;
            mychart.labels =books;
            mychart.draw();
        }
      }
      
      window.onload = drawMyChart;
	</script>
	<script>
		var div = document.getElementById('staticli');
		div.setAttribute("class", "active");
	</script>
</body>
</html>