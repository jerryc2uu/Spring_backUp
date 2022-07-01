<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Singer Information</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/user.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/singer/singer.js"></script>
</head>
<body>
	<div class="w3-content mxw700">
		<div class="w3-col w3-purple w3-center w3-padding w3-margin-bottom">
			<h1>가수 정보</h1>
		</div>
		<div class="w3-col w3-center w3-margin-bottom">
			<div class="w3-col w3-center">
				<div class="w3-third">
					<select class="w3-col w3-select w3-border" id="gn">
						<option disabled selected>::: 세대 선택 :::</option>
						<option value="과거">과거</option>
						<option value="현재">현재</option>
					</select>
				</div>
				<div class="w3-third" style="padding-left: 5px;">
					<select class="w3-col w3-select w3-border" id="gen">
						<option disabled selected>::: 성별 선택 :::</option>
						<option value="남자" class="w3-text-blue">남자</option>
						<option value="여자" class="w3-text-blue">여자</option>
					</select>
				</div>
				<div class="w3-third" style="padding-left: 5px;">
					<select class="w3-col w3-select w3-border" id="stype">
						<option disabled selected>::: 타입 선택 :::</option>
						<option value="S">솔로</option>
						<option value="G">그룹</option>
					</select>
				</div>
			</div>
			<div class="w3-col w3-margin-top">
				<div class="w3-half">
					<select class="w3-col w3-select w3-border w3-center" id="gselect">
						<option disabled selected>::: 가수 선택 :::</option>
					</select>
				</div>
				<div class="w3-half" style="padding-left: 5px;">
					<select class="w3-col w3-select w3-border w3-center" id="mselect">
						<option disabled selected>::: 멤버 선택 :::</option>
					</select>
				</div>
			</div>
		</div>
		<div class="w3-col w3-center w3-margin-bottom">
		<!-- 가수 사진 출력 -->
		</div>
	</div>
</body>
</html>