<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entities.Category"%>

<h4>Create New Category</h4>
<form action="${pageContext.request.contextPath}/admin/category/create">
	<input type="hidden" name="id" value="" placeholder=""/>
	<input type="text" name="name" value="Category Name"/>
	<input type="submit" value="Create"/>	
</form>
