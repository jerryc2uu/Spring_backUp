<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GITHRD 댓글 게시판 댓글 수정</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/user.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/reBoard/reBoard.js"></script>
<style type="text/css">
	.w3-button {
		padding: 1px 16px;
	}
	.box120 {
		width: 135px;
		height: auto;
	}
	.mid {
		position: relative;
		top: 5px;
		right: 5px;
	}
</style>
<script type="text/javascript">
/* 
  이것은 테스트
  정말 테스트~~~
 	
  var txt = '이것은 테스트!
  				정말 테스트~~~';
  
 */
	var txt = '${DATA.body}';
</script>
</head>
<body>
	<div class="w3-content mxw750 w3-margin-top">
		<!-- 페이지 헤더 -->
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-pink w3-center w3-padding mg0">GITHRD 댓글 게시글 수정</h1>
			<nav class="w3-bar w3-amber">
				<div class="w3-col w150 w3-button w3-small w3-green menubtn" id="hbtn">home</div>
<c:if test="${not empty SID}">
				<div class="w3-col w150 w3-button w3-small w3-red w3-right menubtn" id="obtn">logout</div>
</c:if>
			</nav>
		</header>
		
		<!-- 페이지 본문 -->
		<div class="w3-col">
			<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
				<div class="w3-col box120 pdAll10 w3-border-right">
					<img src="/www/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
					<span class="w3-col w3-center ft10 mid"><b>${SID}</b></span>
				</div>
				<div class="w3-rest w3-padding">
					<div class="w3-col w3-border-bottom">
						<span class="w3-col w3-left mgb10 ft10 "><strong>${DATA.sdate}</strong></span>
					</div>
					<input type="hidden" id="obody" value="${DATA.body}">
					<form method="POST" action="/www/reBoard/editProc.blp" 
											id="frm" name="frm" class="w3-col w3-margin-top">
						<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
						<input type="hidden" name="vw" value="${param.vw}">
						<input type="hidden" id="bno" name="bno" value="${DATA.bno}">
						<textarea class="w3-col w3-padding ft12" id="body" name="body"
									style="resize: none;">${DATA.body}</textarea>
					</form>
				</div>
			</div>
		</div>
		
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-button w3-green" id="listbtn">리스트</div>
			<div class="w3-third w3-button w3-blue" id="rbtn">리셋</div>
			<div class="w3-third w3-button w3-deep-orange" id="editbtn">글수정</div>
		</div>	
	</div>
</body>
</html>