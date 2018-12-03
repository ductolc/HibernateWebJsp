<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entities.Category"%>

<div class="">
	<a href="${pageContext.request.contextPath}/admin/category/create">+ Create New Category</a>
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
			<th>Category Id</th>
			<th>Category Name</th>
			<th>Action</th>
		</tr>
	</thead>
	<c:forEach var="category" items="${categoryList}">
		<tr>
			<td>${category.id}</td>
			<td>${category.name}</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/category/delete?id=${category.id}">Delete</a>
				<a href="${pageContext.request.contextPath}/admin/category/edit?id=${category.id}">Edit</a>
			</td>
		</tr>
	</c:forEach>
</table>
