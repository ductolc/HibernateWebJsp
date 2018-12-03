<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entities.Category"%>

<h4>Edit Category</h4>
<form action="${pageContext.request.contextPath}/admin/category/edit">
	<input type="hidden" name="id" value="${categoryEdit.id}"/>
	<input type="text" name="name" value="${categoryEdit.name}"/>
	<input type="submit" value="Update"/>	
</form>
