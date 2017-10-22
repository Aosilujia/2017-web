<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Home">Sbook</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li id="homeli"><a href="Home">Home</a></li>
					<li id="bookli"><a class="color1" href="Booklist">All
							Books</a></li>
					<li id="staticli"><a href="bookStatic">Sales Static</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Administrator Page<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="allUsersPro">Users</a></li>
							<li><a href="allBooksPro">Books</a></li>
							<li><a href="allOrdersPro">Orders</a></li>
							<li class="divider"></li>
							<li><a href="allOrderitemsPro">Orderitems</a></li>
							<li class="divider"></li>
							<li><a href="allBookstockPro">Bookstock</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input class="form-control" type="text"
										name="keyword">
					</div>
					<button type="button" class="btn btn-default" id="search">Search</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<%
							String username = (String) session.getAttribute("users");
						%> <%
 	if (username == null) {
 %> <a href="login">Login</a> <%
 	} else {
 %> <a>"<%=username%>"
					</a> <%
 	}
 %>
					</li>
					<li class="dropdown" id="userli"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Personal Center<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li id="accountli"><a href="Account">Account</a></li>
							<li><a href="logout">Logout</a></li>
							<li id="cartli"><a href="allCartsPro">My Cart</a></li>
						</ul></li>
				</ul>
			</div>

		</nav>
	</div>
</div>
