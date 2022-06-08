$(document).ready(function(){

	//멤버리스트 버튼
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/memberList.blp');
	});
	
	//회원 정보 수정 버튼
	$('#ebtn').click(function(){
		$('#frm').attr('action', '/www/member/myInfoEdit.blp');
		$('#frm').submit();
	});
	
	//회원 탈퇴 버튼
	$('#dbtn').click(function(){
		$('#frm').attr('action', '/www/member/delMember.blp');
		$('#frm').submit();
	});

});
