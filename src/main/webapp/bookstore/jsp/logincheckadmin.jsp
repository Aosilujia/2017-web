
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
		if (session.getAttribute("administrator") == null) {
	%>
	<script type="text/javascript" language="javascript">
		alert("您没有管理员权限，请更换账号或进行普通浏览");
		top.location.href = "Home";
	</script>
	<%
		}
	%>
