<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin.css" />
</head>
<body>

	<div class="main-admin">
		<div class="side-bar">
			 <jsp:include page="/WEB-INF/template/admin_template/sideBar.jsp"/>
		</div>
		
		<div class="side-bar-vt">
		</div>

		<div class="content">
			<jsp:include page="/WEB-INF/pages/admin/${param.content}.jsp"/>
		</div>
	</div>
	  
</body>
</html>