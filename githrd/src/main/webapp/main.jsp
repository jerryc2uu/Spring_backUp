<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>메인페이지</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/user.css">
<script type="text/javascript" src="/boara/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/boara/resources/js/main.js"></script>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
img {
   width: 150px; 
   height: 200px;
}
</style>
</head>
<body>
<!-- #############################여기서부터 아래 표시한 곳까지 모든 페이지에서 동일. -->
<!-- <script type="text/javascript" src="/boara/resources/js/main.js"></script> 모든 페이지에 복붙해주세요. -->
   <!-- Navbar -->
   <div class="w3-top">
     <div class="w3-bar w3-indigo w3-card w3-left-align w3-large">
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="main">메인</a>
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="collection">컬렉션</a>
<c:if test="${not empty SID}">      
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="mwrite">글작성</a>
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="mcoll">새 컬렉션</a>
</c:if>        
        <h4 style="float: right; padding-right:40px;">Boara</h4>
     </div>
   </div>
   
   <!-- Header -->
   <header class="w3-container w3-indigo w3-center" style="padding:128px 16px">
     <h1 class="w3-margin w3-jumbo">Boara</h1>
<c:if test="${empty SID}">
     <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top" id="mlogin">Login</button>
</c:if>
<c:if test="${not empty SID}">
     <button class="w3-button w3-indigo w3-padding-large w3-large w3-margin-top" id="msid">${SID}</button>     
     <button class="w3-button w3-indigo w3-padding-large w3-large w3-margin-top" id="mlogout">Logout</button>     
</c:if>   
   </header>
<!-- #################여기까진 모든 페이지에서 동일. 복붙해주세요 -->  



   <!-- First Grid -->
   <div class="w3-row-padding w3-padding-64 w3-container" style="margin: 0 auto;">		
      <div class="w3-col w3-display-container" style="margin: 0 auto;">
        	
		
         <!-- 컬렉션 리스트 보이는 곳 -->
         <div style = "margin-left: 340px; margin-bottom: 60px;">
            <h3 class="w3-padding mhot" style="float: left;">오늘의 HOT 컬렉션!</h3>
            <button class="w3-indigo w3-hover-grey mhot" style="border: none; margin-top: 18px; margin-left: 500px;">더보기</button>
         </div>
         <div class="w3-center w3-col">
<c:forEach var="data" items="${LIST}">
			<div class="inblock w3-center collectionlist" id="${data.cno}" style="width: 150px; height: 160px; margin-left: 20px; padding-left: 20px;">
	         	<div class="picbox">
	<c:if test="${not empty data.savename}">
	               <img class="pic w3-card-4" src="/boara/resources/upload/${data.savename}">
	</c:if>
	<c:if test="${empty data.savename}">
	               <img class="pic w3-card-4" src="/boara/resources/img/noimage.jpg">
	</c:if>
	         	</div>
               <div>${data.cname}</div>
	        </div>
</c:forEach>
	  	 </div>
	  	 <!-- 컬렉션 리스트 보이는 곳 끝남 -->
	  	 
	  	 
   		 <!-- 페이지 처리 시작 -->
			<div class="w3-center">
				<div class="w3-bar w3-border w3-round-medium w3-card w3-margin-top w3-margin-bottom">
		<c:if test="${PAGE.startPage eq 1}">
					<div class="w3-bar-item w3-light-grey">&laquo;</div>
		</c:if>
		<c:if test="${PAGE.startPage ne 1}">
					<div class="w3-bar-item w3-button w3-hover-blue mpbtn" id="${PAGE.startPage - 1}">&laquo;</div>
		</c:if>
		<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
				<c:if test="${page eq PAGE.nowPage}">
					<div class="w3-bar-item w3-orange">${page}</div>
				</c:if>
				<c:if test="${page ne PAGE.nowPage}">
					<div class="w3-bar-item w3-button w3-hover-blue mpbtn" id="${page}">${page}</div>
				</c:if>
		</c:forEach>
				<c:if test="${PAGE.endPage eq PAGE.totalPage}">
					<div class="w3-bar-item w3-light-grey">&raquo;</div>
				</c:if>
				<c:if test="${PAGE.endPage ne PAGE.totalPage}">
					<div class="w3-bar-item w3-button w3-hover-blue mpbtn" id="${PAGE.endPage + 1}">&raquo;</div>
				</c:if>
				</div>
			</div>
			<!-- 페이지 처리 태그 끝 -->
			
      </div>
   </div>
   
   
   <!-- 데이터 전송용 form 태그 -->
	<form method="POST" action="" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
		<input type="hidden" id="cno" name="cno">
	</form>
   
   
   <!-- Footer -->
   <footer class="w3-container w3-padding-64 w3-center w3-opacity">
   		<p>(주)보아라</p>
   </footer>
</body>
</html>