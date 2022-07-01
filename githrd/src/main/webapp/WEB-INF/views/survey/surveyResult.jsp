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
<!-- 
	현재 설문에 응답한 사람 수 조회
	득표율 조회
	
		득표율 = 해당 보기 선택한 사람 수 * 100. / 설문 참여한 사람 수
 -->
	<form method="POST" action="" id="frm" name="frm">
		<input type="hidden" name="id" value="${SID}">
		<input type="hidden" name="sino" value="${param.sino}">
		<input type="hidden" name="title" value="${param.title}">
	</form>
	<div class="w3-content w3-center mx650">
		<h1 class="w3-pink w3-padding w3-card-4">설문 조사 결과</h1>
			
		<h2 class="w3-col w3-text-indigo w3-margin-bottom w3-margin-top">${param.title}</h2>	

<!-- 설문 문항 내용 만들기 -->		
<c:forEach var="quest" items="${DATA.bogi}" varStatus="st"><!-- DATA : 설문 주제 1개에 해당하는 정보 담은 vo, bogi : 설문 주제 1개에 해당하는 문항들 -->
		<div class="w3-col w3-margin-top w3-padding w3-card-4">
			<h3 class="w3-left-align quest">${st.count}. ${quest.body}</h3>
			<div class="w3-col" style="padding-left: 70px;">
	<!-- 설문문항의 보기 만들기 -->
	<c:forEach var="answer" items="${quest.bogi}" varStatus="bst">
				<h4 class="w3-col w3-left-align mb0"> <label > ${bst.count}) ${answer.body} <span class="w3-text-indigo posRtvBt2"><small>- ${answer.per}%</small></span></label></h4>
				<div class="w3-col pdh2780">
					<div class="w3-col w3-border w3-border-grey">
						<div class="w3-col w3-blue" style="width: ${answer.per}%; height: 15px;"></div>
					</div>
				</div>
	</c:forEach>
			</div>
		</div>
</c:forEach>
	
		<div class="w3-col w3-margin-top margin-bottom w3-card-4">
			<div class="w3-half w3-green w3-button" id="hbtn">home</div>
			<div class="w3-half w3-blue w3-button" id="lbtn">list</div>
		</div>	
	</div>
</body>
</html>