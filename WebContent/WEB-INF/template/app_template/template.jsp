<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/template/app_template/header.jsp"/>
		<section>
		  <jsp:include page="//WEB-INF/template/app_template/navigator.jsp"/>
		  <jsp:include page="/WEB-INF/pages/${param.content}.jsp"/>
		</section>
	<jsp:include page="/WEB-INF/template/app_template/footer.jsp"/>
</body>
</html>