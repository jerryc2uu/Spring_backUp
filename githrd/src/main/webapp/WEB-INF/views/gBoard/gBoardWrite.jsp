<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GITHRD 방명록 글쓰기</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/user.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/gBoard/gBoard.js"></script>
</head>
<body>
	<div class="w3-content mxw650 w3-margin-top">
		<!-- 페이지 헤더 -->	
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-pink w3-center w3-padding mg0">BlackPink 방명록 글쓰기</h1>
			<nav class="w3-bar w3-yellow">
				<div class="w3-col w150 w3-button w3-small w3-green" id="hbtn">home</div>
				<div class="w3-col w150 w3-button w3-small w3-red w3-right" id="obtn">logout</div>
			</nav>
		</header>
		
		<form method="POST" action="/www/gBoard/gBoardWriteProc.blp" name="frm" id="frm"
				class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding mgb20">
			<input type="hidden" name="mno" value="${DATA.mno}">
			<div class="w3-col box120 pdAll10 w3-border-right w3-border-deep-orange">
				<img src="/www/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">		
			</div>
			<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom">
					<span class="mgb10 ft10"><b>${SID}</b></span>
					<!-- <span class="w3-button w3-right w3-red w3-hover-orange mgb10 ft10">등록</span> -->
				</div>
				<div class="w3-col w3-margin-top">
					<textarea name="body" id="body" class="w3-col w3-padding ft12 w3-border-orange" style="resize: none; height: 100%;"></textarea>
				</div>
			</div>
			<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}"><!-- req, session은 생략 가능 -->
		</form>		
		<div class="w3-col w3-card-4">
			<div class="w3-third w3-button w3-green w3-hover-lime" id="listbtn">list</div>
			<div class="w3-third w3-button w3-amber w3-hover-yellow" id="rbtn">reset</div>
			<div class="w3-third w3-button w3-deep-orange w3-hover-yellow" id="addbtn">글등록</div>
		</div>
	</div>
</body>
</html>