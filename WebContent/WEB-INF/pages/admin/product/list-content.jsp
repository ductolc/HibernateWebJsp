<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entities.Category"%>
<div class="">
	<a href="${pageContext.request.contextPath}/admin/product/create">+ Create New Product</a>
</div>

<div class="msg">
	<c:out value="${msg}"/>
</div>
<div class="err">
	<c:out value="${err}"/>
</div>

<table>
	<thead>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Action</th>
		</tr>
	</thead>
	<c:forEach var="product" items="${productList}">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/product/delete?id=${product.id}">Delete</a>
				<a href="${pageContext.request.contextPath}/admin/product/edit?id=${product.id}">Edit</a>
			</td>
		</tr>
	</c:forEach>
</table>