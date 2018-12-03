<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entities.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product page</title>
</head>
<body>
	<div class="list-item">
		<c:forEach var="product" items="${productList}">
			<div class="item">
				<p>${product.id}</p>
				<p>${product.name}</p>
				<a href="${pageContext.request.contextPath}/product/buy?id=${product.id}">Buy</a>
				<a href="${pageContext.request.contextPath}/product/detail?id=${product.id}">Detail</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>