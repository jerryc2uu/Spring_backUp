<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#frm').submit();
	});
</script>
</head>
<body>
<c:if test="${not empty VIEW}">
	<form method="POST" action="${VIEW}" id="frm" name="frm">
		<input type="hidden" name="id" value="${param.id}">		
		<input type="hidden" name="sino" value="${param.sino}">		
		<input type="hidden" name="title" value="${param.title}">		
	</form> 
</c:if>		
</body>
</html>