<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/base.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/survey/survey.js"></script>
<style type="text/css">
	label {
		font-size: 16pt;
	}
	
	#msg {
		font-size: 20pt;
		font-weight: bold;
		color: indigo;
	}
</style>
</head>
<body>
	<form method="POST" action="" id="frm" name="frm">
		<input type="hidden" name="id" value="${SID}">
		<input type="hidden" name="sino" value="${DATA.sino}">
		<input type="hidden" name="title" value="${DATA.title}">
	</form>
	<div class="w3-content w3-center mx650">
		<h1 class="w3-blue w3-padding w3-card-4">설문 조사</h1>
			
		<h2 class="w3-col w3-text-indigo w3-margin-bottom w3-margin-top">${DATA.title}</h2>	
		
		<form name="frm1">
<c:forEach var="quest" items="${DATA.bogi}" varStatus="st"> 	
		<div class="w3-col w3-margin-top w3-padding w3-card-4">
			<h3 class="w3-left-align quest">${st.count}. ${quest.body}</h3>
			<div class="w3-col" style="padding-left: 70px;">
	<c:forEach var="answer" items="${quest.bogi}" varStatus="bst">			
				<h4 class="w3-col w3-left-align"><input type="radio" name="${quest.sqno}" id="${answer.sqno}"value="${answer.sqno}"> <label for="${answer.sqno}">${bst.count}. ${answer.body}</label></h4>
	</c:forEach>		
			</div>
		</div>
</c:forEach>
		</form>
	
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-green w3-button" id="lbtn">list</div>
			<div class="w3-third w3-blue w3-button" id="rbtn">reset</div>
			<div class="w3-third w3-orange w3-button" id="sbtn">submit</div>
		</div>	
	</div>
</body>
</html>