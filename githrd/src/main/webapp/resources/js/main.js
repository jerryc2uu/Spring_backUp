$(document).ready(function(){
	//로그인 버튼
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/login.blp');
	});

	//로그아웃 버튼
	$('#obtn').click(function(){
		$(location).attr('href', '/www/member/logout.blp');
	});
	
	//join 버튼
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');		
	});
	
	//회원 목록 버튼
	$('#mlbtn').click(function(){
		$(location).attr('href', '/www/member/memberList.blp');
	});
	
});