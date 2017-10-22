<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<body>
	<%
		session.setAttribute("users",null);
		session.setAttribute("administrator",null);
		session.setAttribute("uid", null);
	%>
	<script type="text/javascript" language="javascript">
		top.location.href = "Home";
	</script>

<body>