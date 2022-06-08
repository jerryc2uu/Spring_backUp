<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/base.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/member/memberList.js"></script>
<style type="text/css">
</style>
<script type="text/javascript"></script> 
</head>
<body>	
	<form method="post" action="/www/member/memberInfo.blp" name="frm" id="frm">
		<input type="hidden" name="mno" id="mno">
	</form>
	<div class="w3-content mx650 w3-center">
		<!-- 타이틀 태그 -->
		<h1 class="w3-pink w3-padding w3-card-4">GITHRD Member List</h1>
		<div class="w3-col w3-margin-top">
<c:forEach var="data" items="${LIST}">
<%-- 아래 클래스에 입력한 lbtn은 버튼태그에 이벤트 등록용 클래스 --%>
			<div class="box w150 w3-button w3-blue ml10 mb5 lbtn" id="${data.mno}">${data.name}</div>
</c:forEach>	
		</div>
		<div class="w3-col w3-margin-top">
			<div class="w3-col w3-button w3-orange w3-hover-amber w3-card-4" id="hbtn">home</div>
		</div>
	</div>
</body>
</html>