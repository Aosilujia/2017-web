
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<body>
	<%
		if (session.getAttribute("users") == null) {
	%>
	<script type="text/javascript" language="javascript">
		alert("您还没有登录，请登录...");
		top.location.href = "login";
	</script>
	<%
		}
	%>

<body>