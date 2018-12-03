<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hibernate JSP Servlet</title>

<style>

	.menu {
	    width: 45%;
	}
	
	ul.menu li a {
	    padding: 20px;
	    display: block;
	    background: #ddd;
	    border-bottom: solid 1px;
	}
</style>
</head>
<body>
	<ul class="menu">
		<li><a href="${pageContext.request.contextPath}/category">Category</a></li>
		<li><a href="${pageContext.request.contextPath}/product">Product</a></li>
		<li><a href="${pageContext.request.contextPath}/admin">Admin Dashboard</a></li>
	</ul>
</body>
</html>